(defproject vrtic-rest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [clj-http "3.12.3"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"],
                 [ring/ring-json "0.4.0"]
                 [ring/ring-defaults "0.3.1"]
                 [korma "0.4.3"]
                 [org.clojure/java.jdbc "0.7.5"]
                 [com.microsoft.sqlserver/mssql-jdbc "12.2.0.jre11"]
                 [http-kit "2.3.0"]
                 [org.clojure/data.json "0.2.6"]
                 [metosin/compojure-api "2.0.0-alpha19"]
                 [org.postgresql/postgresql "42.3.3"]
                 ]

  :ring {:handler vrtic-rest.handler/app}
  :plugins  [[lein-ring "0.12.5"]
             [compojure "1.6.1"]]
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]
                        [lein-ring "0.12.0"]]}})
