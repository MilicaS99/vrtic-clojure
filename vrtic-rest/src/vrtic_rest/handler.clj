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

      (GET "/:programID" []
        :summary "Vrati program po Id-ju"
        :path-params [programID :- s/Any]
        (ok (vratiProgramPoId programID)))

      (POST "/dodaj-program"  []
        :summary "Dodaj program"
        :body [body DodajProgramModel]
        (def createResult (dodajProgram body))
        (ok createResult))

      (POST "/izmeni-program/:programID"  []
        :summary "Izmeni program"
        :path-params [programID :- s/Any]
        :body [body IzmeniProgramModel]
        (def createResult (izmeniProgram programID body))
        (ok createResult))

      (DELETE "/obrisi-program/:programID" []
        :summary "Obrisi program"
        :path-params [programID :- s/Any]
        (def deleteResult (obrisiProgram programID))
        (ok nil)))
    )
  )