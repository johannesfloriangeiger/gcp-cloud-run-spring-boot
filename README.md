# Prerequisite

Project `$PROJECT_ID` exists in region `$REGION` and has the Container Registry enabled: `gcloud services enable --project $PROJECT_ID containerregistry.googleapis.com`

# Build

## API

```
(cd api \
    && mvn clean install \
    && docker build --platform linux/amd64 . -t gcr.io/$PROJECT_ID/gcp-cloud-run-spring-boot \
    && docker push gcr.io/$PROJECT_ID/gcp-cloud-run-spring-boot)
```

## Terraform

```
terraform -chdir=terraform plan -var project=$PROJECT_ID -var region=$REGION -out plan.out
terraform -chdir=terraform apply plan.out
```

# Test

```
curl $(terraform -chdir=terraform output -json \
    | jq -r .uri.value)/example
```

You should receive `Hello, Spring Boot via GCP Cloud Runner!`