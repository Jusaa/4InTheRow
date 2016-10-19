###Rakennekuvaus

#### [Luokkakaavio](https://github.com/Jusaa/4InTheRow/blob/master/dokumentaatiohakemisto/luokkakaavio.png)

Peli koostuu logiikka, käyttöliittymä ja UI paketeista.

Logiikassa on Pelaajat(Pelaaja interface, IhmisPelaaja ja TietokonePelaaja), Peli, Tietokanta ja Voiton ja VuoronTarkistajat.          
UI'ssa on Piirtaja ja Kuvantuoja ja käyttöliittymässä Mainin lisäksi HiirenKuuntelija.

HiirenKuuntelijan avulla käyttäjän painallukset ohjataan Peli luokalle, joka muita logiikkaluokkia hyödyntäen pyörittää peliä.         
Peli myös käyttää Piirtajaa pelikentän ja valikoiden piirtämiseen

Piirtaja hoitaa swing komponenttien teon, ja Kuvantuoja tuo niihin vain sisällöksi kuvat
