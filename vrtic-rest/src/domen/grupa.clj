(ns domen.grupa
  (:require [schema.core :as s]
            [ring.swagger.schema :refer [coerce!]]))

(s/defschema GrupaModel {:GrupaID    Integer
                         :NazivGrupe  String
                         :Uzrast      String
                         :ProgramID     Integer
                         :VaspitacID    Integer})

(s/defschema DodajGrupaModel {:NazivGrupe  String
                              :Uzrast      String
                              :ProgramID     Integer
                              :VaspitacID    Integer})

(s/defschema IzmeniGrupaModel {:NazivGrupe  String
                               :Uzrast      String
                               :ProgramID     Integer
                               :VaspitacID    Integer})