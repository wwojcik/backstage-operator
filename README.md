# Backstage Operator

## Develop

install and configure [pre-commit](https://pre-commit.com/)
optional tools:

* [asdf](https://github.com/asdf-vm/asdf)
* [direnv](https://github.com/direnv/direnv)

Direnv config .envrc file:

```text
use asdf
export TESTCONTAINERS_RYUK_DISABLED="true"
```

### Useful commands

Run dev mode

```bash
./mvnw quarkus:dev
```

Test

```bash
./mvnw quarkus:test
```

Build

```bash
./mvnw quarkus:build
```

### Tutorials

* [remote development tutorial](https://developers.redhat.com/blog/2021/02/11/enhancing-the-development-loop-with-quarkus-remote-development?extIdCarryOver=true)
