FROM ubuntu:latest
LABEL authors="egghost"

ENTRYPOINT ["top", "-b"]