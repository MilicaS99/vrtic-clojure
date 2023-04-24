(ns domen.program
  (:require [schema.core :as s]
            [ring.swagger.schema :refer [coerce!]]))

(s/defschema ProgramModel {
  :ProgramID    Integer
  :Naziv        String
  :Opis         String
})

(s/defschema DodajProgramModel {
  :Naziv        String
  :Opis         String
})


(s/defschema IzmeniProgramModel {
  :Naziv        String
  :Opis         String
})
