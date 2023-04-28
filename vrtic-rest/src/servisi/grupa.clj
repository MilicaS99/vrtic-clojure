(ns servisi.grupa
  (:require [domen.grupa]
            [korma.core :refer :all]))

(defentity Grupa)

(defn parseGrupaId [s]
  (Integer. (re-find  #"\d+" s)))

(defn vratiGrupuPoId [grupaID]
  (select Grupa
          (where {:GrupaID [= (parseGrupaId grupaID)]})))

(defn vratiGrupuPoImenu [imeGrupe]
  (select Grupa
          (where {:NazivGrupe [= imeGrupe]})))

(defn vratiSveGrupe []
  (select Grupa))

(defn dodajGrupu [grupaZaDodavanje]
  (insert Grupa
          (values {:NazivGrupe (get grupaZaDodavanje :NazivGrupe)
                   :Uzrast (get grupaZaDodavanje :Uzrast)
                   :ProgramID (get grupaZaDodavanje :ProgramID)
                   :VaspitacID (get grupaZaDodavanje :VaspitacID)}))
  (vratiGrupuPoImenu (get grupaZaDodavanje :NazivGrupe)))

(defn izmeniGrupu [grupaID grupaZaIzmenu]
  (update Grupa
          (set-fields {:NazivGrupe (get grupaZaIzmenu :NazivGrupe)
                       :Uzrast (get grupaZaIzmenu :Uzrast)
                       :ProgramID (get grupaZaIzmenu :ProgramID)
                       :VaspitacID (get grupaZaIzmenu :VaspitacID)}) (where {:GrupaID [= (parseGrupaId grupaID)]}))
  (vratiGrupuPoId grupaID))

(defn obrisiGrupu [grupaID]
  (delete Grupa
          (where {:GrupaID [= (parseGrupaId grupaID)]})))