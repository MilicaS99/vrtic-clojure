(ns domen.vaspitac
  (:require [schema.core :as s]
            [ring.swagger.schema :refer [coerce!]]))

(s/defschema VaspitacModel {:VaspitacID    Integer
                            :Ime        String
                            :Prezime    String
                            :Pol        String
                            :Kontakt    String
                            :Adresa     String})

(s/defschema DodajVaspitacModel {:Ime        String
                                 :Prezime    String
                                 :Pol        String
                                 :Kontakt    String
                                 :Adresa     String})

(s/defschema IzmeniVaspitacModel {:Ime        String
                                  :Prezime    String
                                  :Pol        String
                                  :Kontakt    String
                                  :Adresa     String})