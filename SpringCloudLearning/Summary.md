1. Spring Cloud Config Server
   1. 同樣適用 profiles
   2. 需要調用 cloud config server 的 service 需要在 application.properties 設定 URL
2. 微服務調用
   1. Dynamic port (by application.properties)
   2. RestTemplate (需要有整個 URL 來做呼叫, 類似 curl 的感覺)
   3. Feign client (實現 load balance)
      1. 需要設定 dependency
      2. 使用 @FeignClient, @EnableFeignClients
      3. 建立 proxy interface
      4. 沒有 naming server 的話需要 hardcode ip:port
   4. Naming Server (Eureka)
      1. 將各個 instance 做註冊, 記錄各個 instance 的 ip port
      2. dependency 需要有 eureka server 跟 eureka client
      3. client 需要 config eureka server url (docker-compose 使用 env variables 設定)
3. API Gateway
   1. Routing
   2. 也可以結合 eureka 進行 load balance
4. Circuit Breaker
   1. 情境
      1. 當 service down 時回傳 fallback response
      2. 如果後面 service down 時不往後打就回傳，減少負擔
      3. 是否可以 retry
      4. 是否可以限制調用數量
   2. 使用 Resilience4j
      1. retry default
      2. retry max attempts
      3. retry wait-duration & enable-exponential-backoff
      4. retry fallbackMethod
      5. circuit breaker
         1. 當失敗比例太高就不再 call service, 直接 fallbackMethod
         2. 有分 closed, open, half-open 三個狀態
         3. 失敗比例太高就 closed -> open
         4. 一定時間後 open -> half-open
         5. half-open 下傳送部分 request, 如果成功則回到 closed, 反之 open
   3. Zipkin
      1. 需要被追蹤的都要在 pom.xml 跟 application.properties 加入參數
      2. 如果用到 feign 的話需要再加入額外的 dependency
      3. 或是用 restTemplate 要做額外處理
5. docker compose
   1. 在 pom.xml 的 maven-plugin 設定 image name & tag
   2. <pullPolicy> 是指定如果沒有 build image 需要 base image 何時需要 pull (default 是無條件 pull)
   3. 執行 spring-boot:build-image -DskipTests 來 build images
6. Kubernetes
   1. Node
      1. 一個 VM or 實體機
   2. Pod
      1. 一個 Node 可以有多個 Pod
      2. Pod is an collection of containers that can run on a host
      3. Pod 會有自己的 IP
      4. 同一個 pod 下的 container 共用資源, 並且可以用 localhost 調用
   3. ReplicaSets
      1. 當 Pod 低於期望數量時, 自動創建 Pod
   4. Deployment
      1. 可進行 zero down time 部署
      2. 依序將舊版的 pod 數 -1, 新版 pod 數 + 1
   5. Service
      1. kubectl expose 時產生
      2. 提供外部接口
   6. Master Node, Worker Nodes
      1. Master Node
         1. Distribute Database (etcd)
            1. Deployment, Service, Configuration 放在 etcd
         2. API Server (kube-apiserver)
            1. 接收 kubectl 或是 GCP 所發出的指令
         3. Scheduler (kube-scheduler)
            1. 將 pod 調度到哪一個 Node 上
         4. Controller Manager (kube-controller-manager)
            1. 讓 cluster 的狀態跟 desired state 相符
         5. 應用程式通常不會部署在 Master Node
      2. Worker Nodes
         1. Node Agent (kubelet)
            1. 將事件回傳給 Master Node
            2. 例如某個 pod 故障, 回報給 master node 的 controller manager
         2. Networking Component (kube-proxy)
            1. expose pod service
         3. Container Runtime (OCI open container interface - docker, rkt etc)
            1. 運行與管理 container 的軟體
         4. Pods (Multiple pods running containers)
