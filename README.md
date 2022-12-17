# dev-rss

This application was created to serve RSS/Atom feeds for blogs and resources which do not provide their own feeds. E.g. no feed is available from Maven Central artifacts and from certain statically generated blogs.

## Provided feeds

The feeds can be accessed from `http(s)://<server url>:<port>/feed/<feed name>`, e.g. `https://myserver.com/feed/gradle`.

All available feeds:

```
GET /feed/flyway
GET /feed/gradle
GET /feed/guava
GET /feed/hibernate
GET /feed/jpabuddyblog
GET /feed/junit
GET /feed/mockito
GET /feed/selenium
GET /feed/spring/batch
GET /feed/spring/boot
GET /feed/spring/core
GET /feed/spring/data
GET /feed/spring/mvc
GET /feed/spring/security
GET /feed/vaadin
```

## Other endpoints

Health endpoint:

```
GET /actuator/health
```

## Customizing

First, clone this repository and add more feeds to `FeedController.java`.

Default port is 8081 which is customizable in `src/main/resources/application.properties` and can be overridden with `SERVER_PORT` environment variable.

## Deploy to Heroku

Click the button to deploy this app to your Heroku account:

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/emick/dev-rss)