
### Aplicație pentru monitorizare meteorologică
##### Descrierea aplicatiei

Aplicatia este folosita pentru a monitoriza vremea in diferite orase alese de utilizator. Aplicatia este scrisa in limbajul de programare JAVA. Aplicatia primeste un fisier de intrare ce contine detalii despre mai multe orase. Pe baza detaliilor din fisier, aplicatia va realiza request-uri catre API-ul OpenWeatherOrg. Va primi un raspuns de tip JSON ce contine detaliile despre vremea din orasul respectiv. Raspunsul de tip JSON va fi parsat pentru a se extrage informatiile ce ne intereseaza. Interfata grafica este realizata cu ajutorul JavaFX iar testele se fac cu ajutorul Maven.

##### Utilizarea aplicatiei
Utilizatorul va selecta tara si orasul cu ajutorul a doua liste din interfata grafica. Dupa ce se selecteaza tara, se vor incarca si orasele din lista de orase. Dupa ce a fost facuta selectia in interfata grafica vor aparea urmatoarele detalii despre orasul ales:
- Numele orasului ales
- data si ora curenta
- imagine reprezentativa pentru vreme
- descrierea vremii
- temperatura in grade C
- temperatura in grade K
- umiditatea
- vizibilitatea
