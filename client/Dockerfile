# Stage 1
FROM node:13.1.0-alpine as node

RUN apk add --no-cache curl bash
RUN curl -o- -L https://yarnpkg.com/install.sh | bash
WORKDIR /usr/src/app
COPY package.json ./
COPY yarn.lock ./
RUN yarn
COPY . .
RUN npm run build

# Stage 2
FROM nginx:1.17.5-alpine
COPY --from=node /usr/src/app/dist/citas-medicas /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
