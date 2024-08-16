docker run  -p 8080:8080 \
            -e "SPRING_PROFILES_ACTIVE=$1" \
            spring-boot-app