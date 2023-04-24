

  (ns domen.konekcija
    (:require [korma.db :as korma]
    ))

(def database {:dbtype "postgresql"
         :dbname "seminarskirad"
         :host "localhost"
         :port 5432
         :user "postgres"
         :password "milica"})

  (korma/defdb db database)