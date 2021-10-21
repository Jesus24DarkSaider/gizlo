FROM node as buildApp

RUN mkdir -p /app

WORKDIR /app

COPY package.json /app

RUN npm install

COPY . /app

RUN npm run build --prod

FROM nginx:1.17.1-alpine

COPY --from=buildApp /app/dist/appgizlo /usr/share/nginx/html
EXPOSE 8015