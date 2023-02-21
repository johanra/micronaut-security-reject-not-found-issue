# micronaut-security-reject-not-found-issue

this project demonstrates an issue where the default setting of 

```
micronaut.security.reject-not-found = true
```

hides a problem which is actually a 413 request entity too large.

To easily reproduce the issue we need to artificially decrease the allowed header size in application.yml

```
micronaut.server.netty.max-header-size: 1
```

Then we can observe the difference between reject-not-found: true & false

reject-not-found: true  (default behaviour)

```
curl --location --request GET 'localhost:8080/api/document/download' -u 'sherlock:password' --head
HTTP/1.1 401 Unauthorized
date: Tue, 21 Feb 2023 16:03:59 GMT
transfer-encoding: chunked
connection: close
```

reject-not-found: false

```
curl --location --request GET 'localhost:8080/api/document/download' -u 'sherlock:password' --head
HTTP/1.1 413 Request Entity Too Large
Content-Type: application/json
content-length: 172
connection: close
```
