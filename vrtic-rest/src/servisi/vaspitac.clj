(ns servisi.vaspitac
  (:require [domen.vaspitac]
            [korma.core :refer :all]))

(defentity Vaspitac)

(defn parseVaspitacId [s]
  (Integer. (re-find  #"\d+" s)))

(defn vratiVaspitacaPoId [vaspitacID]
  (select Vaspitac
          (where {:VaspitacID [= (parseVaspitacId vaspitacID)]})))

(defn vratiVaspitacaPoImenu [ime]
  (select Vaspitac
          (where {:Ime [= ime]})))

(defn vratiSveVaspitace []
  (select Vaspitac))

(defn dodajVaspitaca [vaspitacZaDodavanje]
  (insert Vaspitac
          (values {:Ime (get vaspitacZaDodavanje :Ime)
                   :Prezime (get vaspitacZaDodavanje :Prezime)
                   :Pol (get vaspitacZaDodavanje :Pol)
                   :Kontakt (get vaspitacZaDodavanje :Kontakt)
                   :Adresa (get vaspitacZaDodavanje :Adresa)}))
  (vratiVaspitacaPoImenu (get vaspitacZaDodavanje :Ime)))

(defn izmeniVaspitaca [vaspitacID vaspitacZaIzmenu]
  (update Vaspitac
          (set-fields {:Ime (get vaspitacZaIzmenu :Ime)
                       :Prezime (get vaspitacZaIzmenu :Prezime)
                       :Pol (get vaspitacZaIzmenu :Pol)
                       :Kontakt (get vaspitacZaIzmenu :Kontakt)
                       :Adresa (get vaspitacZaIzmenu :Adresa)}) (where {:VaspitacID [= (parseVaspitacId vaspitacID)]}))
  (vratiVaspitacaPoId vaspitacID))

(defn obrisiVaspitaca [vaspitacID]
  (delete Vaspitac
          (where {:VaspitacID [= (parseVaspitacId vaspitacID)]})))