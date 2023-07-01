# vrtic-clojure

U Vrtic projektu nalazi se vrtic-rest API.
Rest API koristi Leiningen https://leiningen.org/

Vrtic API koristi domenske entitete : Program, Grupu i Vaspitac.   

Vrtić api komunicira sa PostgreSQL bazom.  

Koriscena je korma za komunikaciju sa bazom kao i ring za web server.   

Komanda za pokretanje projekta je lein ring server.

Vrtic rest API sadrzi 15 API metoda, od kojih su 5 povezane za vaspitaca, 5 povezane za program i 5 povezane za grupu.

Sto se tice vaspitaca imamo sledece opcije:.    

    1. GET /vaspitaci - Pregled svih vaspitaca  
    2. POST /vaspitaci/dodaj-vaspitaca - Dodavanje vaspitaca
    3. DELETE /vaspitaci/obrisi-vaspitaca/{vaspitacID} - Brisanje vaspitaca
    4. POST /vaspitaci/izmeni-vaspitaca/{vaspitacID} Izmena vaspitaca
    5. GET /vaspitaci/{vaspitacID} - Vracanje vaspitaca po nekom specificnom Id-ju

Sto se tice programa, imamo sledece opcije:    

    1. GET /programi - Pregled svih programa
    2. GET /programi/{programID} - Pregled nekog specificnog programa po ID-ju
    3. DELETE /programi/obrisi-program/{programID} - Brisanje programa
    4. POST /programi/dodaj-program - Dodavanje programa
    5. POST /programi/izmeni-program/{programID} -Izmena programa

Ideja Vrtic rest API-ja je da vrtic u svom sastavu ima dostupne programe i vaspitace, i da se grupa formira prema nekom programu, i vaspitacu koji vodi tu grupu, pa tako za grupe imamo sledece API metode:   

    1. GET /grupe - Pregled svih grupa
    2. POST /grupe/izmeni-grupu/{grupaID} Izmena grupe
    3. POST /grupe/dodaj-grupu - Dodavanje grupe
    4. DELETE /grupe/obrisi-grupu/{grupaID} - Brisanje grupe
    5. GET /grupe/{grupaID} - Vracanje neke specificne grupe po ID-ju

