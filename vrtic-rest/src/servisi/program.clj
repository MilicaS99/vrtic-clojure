(ns servisi.program
  (:require [domen.konekcija]
            [korma.core :refer :all]))

(defentity Program)

(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

(defn vratiProgramPoId [programID]
  (select Program
     (where {:ProgramID [= (parse-int programID)]})
  ))

(defn vratiProgramPoNazivu [nazivPrograma]
  (select Program
     (where {:Naziv [= nazivPrograma]})
  ))


(defn vratiSvePrograme []
  (select Program))

(defn dodajProgram [programZaDodavanje]
    (insert Program
      (values {
        :Naziv (get programZaDodavanje :Naziv)
        :Opis (get programZaDodavanje :Opis)
      })
  )
  (vratiProgramPoNazivu (get programZaDodavanje :Naziv))
)

(defn izmeniProgram [programID programZaIzmenu]
    (update Program
      (set-fields {
        :Naziv (get programZaIzmenu :Naziv)
        :Opis (get programZaIzmenu :Opis)
      })(where {:ProgramID [= (parse-int programID)]})
  )
  (vratiProgramPoId programID)
)

(defn obrisiProgram [programID]
    (delete Program
      (where {:ProgramID [= (parse-int programID)]}))
)