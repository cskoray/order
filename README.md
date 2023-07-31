# Swagger Hub URL
https://app.swaggerhub.com/organizations/CSKORAY_1/projects/zilch-project

# Open API URL
http://localhost:8086/swagger-ui/index.html

# K8s folder has all the yaml files for the deployment
### api-order-deployment.yaml

### Zilch API

Create a new order

localhost:8085/v1/api/orders/order

```
{
  "paymentToken": "6165e18a-81d8-4c47-8358-d864ab978fe6",
  "paymentType": "ONE",
  "merchantName": "Shopping Mall",
  "productKeys":[
    {
        "productKey":"2bdbe2a8-d81d-48fe-a67a-335cd543b46d",
        "productKey":"cd3fed50-66b0-4ba4-a1f3-67a7ed6966ce"
    }
  ]
}
```
response has new Zilch Cashback added to User credit Limit
```
{
    "status": "success",
    "cashback": 14.995,
    "apr": "0%"
}
```