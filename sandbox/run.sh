mkdir -m 777 .docker

docker network create educaverso-services-network

docker compose -f app/docker-compose.yml up -d --build