# back-payment : back-end service for manage payments

## build
mvn clean package

## Launch
java -jar target/back-payment-0.0.1-SNAPSHOT.jar

## Dockers
sudo ./build.sh version

## Data
```
```
{ 
    "_id" : ObjectId("5bbcfd96880fa941e4ddc1p1"), 
    "date" : "01/01/2018", 
    "description" : "premier paiement"
}
{     
    "_id" : ObjectId("5bbcfd96880fa941e4ddc1p2"), 
    "date" : "01/02/2018", 
    "description" : "second paiement"
}
```