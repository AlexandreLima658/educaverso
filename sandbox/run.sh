mkdir -m 777 .docker

docker compose -f app/docker-compose.yml up -d --build