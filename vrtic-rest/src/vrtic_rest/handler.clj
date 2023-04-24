(ns vrtic-rest.handler
  (:require 
            [domen.konekcija]
            [compojure.api.sweet :refer :all]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [org.httpkit.server :as server]
            [schema.core :as s]
            [domen.program :refer :all]
            [ring.util.http-response :refer :all]
            [servisi.program :refer :all]
          ))

(defn listaPrograma []
  (vratiSvePrograme))

; API METODE

(def app
  (api 
    ; Swagger documentation details
    {
      :swagger {
        :ui "/"
        :spec "/swagger.json"
        :data {
          :info { :title "VRTIC API" :description "API za vrtic"}
          :tags [
            {:name "Programi", :description "Programi u vrticu"}
          ]
        }
      }
    }

    ; Program API
    (context "/programi" []
      :tags ["programi"]

      (GET "/hello-world" [] "Hello World")
      
      (GET "/" []
        :summary "Vrati sve programe"
        (ok (listaPrograma)))
    )
    )
  )