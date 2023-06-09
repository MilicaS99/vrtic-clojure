(ns vrtic-rest.handler
  (:require
   [domen.konekcija]
   [compojure.api.sweet :refer :all]
   [clojure.string :as str]
   [clojure.data.json :as json]
   [org.httpkit.server :as server]
   [schema.core :as s]
   [domen.program :refer :all]
   [domen.vaspitac :refer :all]
   [domen.grupa :refer :all]
   [ring.util.http-response :refer :all]
   [servisi.program :refer :all]
   [servisi.vaspitac :refer :all]
   [servisi.grupa :refer :all]))

(defn listaPrograma []
  (vratiSvePrograme))

; API METODE

(def app
  (api
    ; Swagger documentation details
   {:swagger {:ui "/"
              :spec "/swagger.json"
              :data {:info {:title "VRTIC API" :description "API za vrtic"}
                     :tags [{:name "Programi", :description "Programi u vrticu"}
                            {:name "Vaspitaci", :description "Vaspitaci u vrticu"}
                            {:name "Grupe", :description "Grupe u vrticu"}]}}}

    ; Program API
   (context "/programi" []
     :tags ["programi"]

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



   (context "/vaspitaci" []
     :tags ["vaspitaci"]

   ; VASPITAC

     (GET "/" []
       :summary "Vrati sve vaspitace"
       (ok (vratiSveVaspitace)))

     (GET "/:vaspitacID" []
       :summary "Vrati vaspitaca po Id-ju"
       :path-params [vaspitacID :- s/Any]
       (ok (vratiVaspitacaPoId vaspitacID)))

     (POST "/dodaj-vaspitaca"  []
       :summary "Dodaj vaspitaca"
       :body [body DodajVaspitacModel]
       (def createResult (dodajVaspitaca body))
       (ok createResult))

     (POST "/izmeni-vaspitaca/:vaspitacID"  []
       :summary "Izmeni vaspitaca"
       :path-params [vaspitacID :- s/Any]
       :body [body IzmeniVaspitacModel]
       (def createResult (izmeniVaspitaca vaspitacID body))
       (ok createResult))

     (DELETE "/obrisi-vaspitaca/:vaspitacID" []
       :summary "Obrisi vaspitaca"
       :path-params [vaspitacID :- s/Any]
       (def deleteResult (obrisiVaspitaca vaspitacID))
       (ok nil)))

   (context "/grupe" []
     :tags ["grupe"]

   ; GRUPA

     (GET "/" []
       :summary "Vrati sve grupe"
       (ok (vratiSveGrupe)))

     (GET "/:grupaID" []
       :summary "Vrati grupe po Id-ju"
       :path-params [grupaID :- s/Any]
       (ok (vratiGrupuPoId grupaID)))

     (POST "/dodaj-grupu"  []
       :summary "Dodaj grupu"
       :body [body DodajGrupaModel]
       (def createResult (dodajGrupu body))
       (ok createResult))

     (POST "/izmeni-grupu/:grupaID"  []
       :summary "Izmeni grupu"
       :path-params [grupaID :- s/Any]
       :body [body IzmeniGrupaModel]
       (def createResult (izmeniGrupu grupaID body))
       (ok createResult))

     (DELETE "/obrisi-grupu/:grupaID" []
       :summary "Obrisi grupu"
       :path-params [grupaID :- s/Any]
       (def deleteResult (obrisiGrupu grupaID))
       (ok nil)))))