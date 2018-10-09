PROJECT=${PWD##*/}
VERSION=$1

if [ "$#" -ne 1 ]; then
    echo "Indiquer le numéro de version"
fi

mvn versions:set -DnewVersion=$VERSION

mvn clean package

docker build --build-arg version=$VERSION  --build-arg jarname=$PROJECT -t $PROJECT:$VERSION .
