##Aihe: Blackjack-peli

Toteutetaan Blackjack-peli graafisella käyttöliittymällä. Jakaja toimii tietokoneen ohjaamana ja pelaa normaalien kasinosääntöjen mukaan. (pelaaja voi valita, käytetäänkö S17 vai H17-sääntöä). Ensin toteutetaan versio jossa on vain yksi (ihmispelaajan ohjaama) pelaaja jakajan lisäksi, ja ajan salliessa mukaan voidaan lisätä myös tekoälyn ohjaamia pelaajia.

####Käyttöliittymä

Peliin rakennetaan yksinkertainen graafinen käyttöliittymä, jossa pelikortit piirretään käyttäen valmiita Public Domain -lisenssin alla olevia pelikortteja (lähde: [opengameart.org][Pelikortit]). Pelinäkymän lisäksi käyttöliittymässä on toimintopainikkeet pelin aikana valittaville toiminnoille (aluksi panoksen valinta sekä Hit ja Stand, myöhemmin myös Split ja Double Down, mahdollisesti myös Insurance ja Surrender). Mahdollisuuksien mukaan peliin lisätään myös näppäimistöoikotiet yleisimmille toiminnoille.

####Määrittelyvaiheen luokkakaavio

![Määrittelyvaiheen luokkakaavio](/dokumentaatio/kuvat/M%C3%A4%C3%A4rittelyvaiheen%20luokkakaavio.PNG "Määrittelyvaiheen luokkakaavio")

####Pelin kulku

Jokaisen kierroksen alussa kukin pelaaja valitsee panoksensa. Tämän jälkeen jakaja jakaa kaikille pelaajille sekä itselleen kaksi korttia kullekin. Pelaajien kortit ovat pöydällä kuvapuoli ylöspäin, jakajan korteista vain toinen on kuvapuoli ylöspäin. Tämän jälkeen kukin pelaaja vuorollaan voi ottaa yhden tai useamman lisäkortin pyrkimyksenään päästä mahdollisimman lähelle summaa 21 menemättä kuitenkaan yli. Jos pelaajan korttien arvo ylittää 21, pelaaja häviää panoksensa välittömästi. Korttien arvot ovat seuraavat:  
* Ässä: 1 tai 11
* 2-9: kortin numeron osoittama arvo
* 10 ja kuvakortit: 10

Kun jokainen pelaaja on nostanut haluamansa määrän lisäkortteja, paljastaa jakaja piilossa olleen toisen korttinsa, sekä ottaa lisäkortteja, kunnes pääsee vähintään 17:ään. Tilanteessa, jossa jakajalla on ässä, ja jakajan korttien summa voi olla 7 tai 17 (esim. kortit A, 4, 2), jakajan toiminta riippuu sääntövariaatiosta: jos noudatetaan S17-sääntöä, jakaja ei ota enempää kortteja, mutta H17-variaatiossa jakaja ottaa tässä tilanteessa lisäkortteja, kunnes päätyy uudestaan vähintään summaan 17.

Tämän jälkeen jakaja vertaa omaa kättään kunkin vielä pelissä olevan pelaajan käteen. Jos jakaja on lähempänä 21:tä, pelaaja menettää panoksensa. Jos pelaajan käsi on suurempi, pelaaja saa panoksensa takaisin kaksinkertaisena. Tasapelissä pelaaja ei voita, eikä menetä rahaa. Jos pelaaja saa blackjackin (ensimmäiset kaksi korttia ovat ässä ja jokin kortti, jonka arvo on 10), pelaaja voittaa minkä tahansa jakajan käden (myös summan 21) toista blackjackiä lukuunottamatta. Lisäksi tällöin pelaaja voittaa rahaa puolitoista kertaa panoksensa verran.

####Lisätoiminnot

**Split**: Jos pelaajan ensimmäistä korttia ovat samanarvoiset (kaikki kuvakortit ja kympit laskenaan keskenään samanarvoisiksi), voi pelaaja halutessaan jakaa kortit kahdeksi erilliseksi kädeksi, jolloin pelaajan täytyy asettaa toista kättä varten uusi panos, joka on samansuuruinen alkuperäisen panoksen kanssa. Tällöin kumpikin käsi pelataan vuorollaan normaalien sääntöjen mukaan. Jos jaettuun käteen lisätty kortti muodostaa uuden parin, voi tämän parin jakaa edelleen samojen sääntöjen mukaan. Tyypillisesti yhdellä kierroksella käden voi jakaa korkeintaan 3 kertaa, jonka jälkeen pelaajalla on pöydässä neljä kättä (ja siten myös nelinkertainen panos alkuperäiseen verrattuna). Jos pelaaja jakaa kahdesta ässästä koostuvan käden, ja saa uuteen käteen toiseksi kortiksi jonkin kortin arvolla 10, ei tätä kättä lasketa tavallisesta poiketen blackjackiksi, ja siten voittaa vain panoksen verran rahaa. Lisäksi kumpaankin ässäparista jaettuun käteen saa vain yhden lisäkortin. Jos pelaaja saa uuden ässän jaettuaan ässäparin, ei uutta ässäparia voi enää jakaa.

**Double down**: Saatuaan ensimmäiset kaksi korttia pelaaja voi halutessaan tuplata panoksensa (itse asiassa lisätä panoksensa _korkeintaan_ kaksinkertaiseksi), mutta saa tällöin vain yhden lisäkortin.







[Pelikortit]: http://opengameart.org/content/playing-cards-vector-png
