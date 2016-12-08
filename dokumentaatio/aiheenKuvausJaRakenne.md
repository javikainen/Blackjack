##Aihe: Blackjack-peli

Toteutetaan Blackjack-peli graafisella käyttöliittymällä. Jakaja toimii tietokoneen ohjaamana ja pelaa normaalien kasinosääntöjen mukaan. Käyttäjän hallitseman pelaajan lisäksi peliin voi osallistua maksimissaan kaksi tietokoneen ohjaamaa pelaajaa.

####Käyttöliittymä

Peliin rakennetaan yksinkertainen graafinen käyttöliittymä, jossa pelikortit piirretään käyttäen valmiita Public Domain -lisenssin alla olevia pelikortteja (lähde: [http://freedesignfile.com][Pelikortit]). Pelinäkymän lisäksi käyttöliittymässä on toimintopainikkeet pelin aikana valittaville toiminnoille (panoksen valinta sekä Hit ja Stand).

####Määrittelyvaiheen luokkakaavio

![Määrittelyvaiheen luokkakaavio](/dokumentaatio/kuvat/Luokkakaavio.png "Määrittelyvaiheen luokkakaavio")


####Sekvenssikaavioita käyttötapauksista

![Korttien jakaminen](/dokumentaatio/kuvat/Dealing cards.png "Dealing cards")

![AI pelaa kierroksen](/dokumentaatio/kuvat/Playing AI hand.png "Playing AI hand")

![Voitonmaksu](/dokumentaatio/kuvat/Paying Winnings.png "Paying winnings")


####Pelin kulku

Jokaisen kierroksen alussa kukin pelaaja valitsee panoksensa. Tämän jälkeen jakaja jakaa kaikille pelaajille sekä itselleen kaksi korttia kullekin. Pelaajien kortit ovat pöydällä kuvapuoli ylöspäin, jakajan korteista vain toinen on kuvapuoli ylöspäin. Tämän jälkeen kukin pelaaja vuorollaan voi ottaa yhden tai useamman lisäkortin pyrkimyksenään päästä mahdollisimman lähelle summaa 21 menemättä kuitenkaan yli. Jos pelaajan korttien arvo ylittää 21, pelaaja häviää panoksensa välittömästi. Korttien arvot ovat seuraavat:  
* Ässä: 1 tai 11
* 2-9: kortin numeron osoittama arvo
* 10 ja kuvakortit: 10

Kun jokainen pelaaja on nostanut haluamansa määrän lisäkortteja, paljastaa jakaja piilossa olleen toisen korttinsa, sekä ottaa lisäkortteja, kunnes pääsee vähintään 17:ään. Tilanteessa, jossa jakajalla on ässä, ja jakajan korttien summa voi olla 7 tai 17 (esim. kortit A, 4, 2), jakajan toiminta riippuu sääntövariaatiosta: jos noudatetaan S17-sääntöä, jakaja ei ota enempää kortteja, mutta H17-variaatiossa jakaja ottaa tässä tilanteessa lisäkortteja, kunnes päätyy uudestaan vähintään summaan 17.

Tämän jälkeen jakaja vertaa omaa kättään kunkin vielä pelissä olevan pelaajan käteen. Jos jakaja on lähempänä 21:tä, pelaaja menettää panoksensa. Jos pelaajan käsi on suurempi, pelaaja saa panoksensa takaisin kaksinkertaisena. Tasapelissä pelaaja ei voita, eikä menetä rahaa. Jos pelaaja saa blackjackin (ensimmäiset kaksi korttia ovat ässä ja jokin kortti, jonka arvo on 10), pelaaja voittaa minkä tahansa jakajan käden (myös summan 21) toista blackjackiä lukuunottamatta. Lisäksi tällöin pelaaja voittaa rahaa puolitoista kertaa panoksensa verran.

[Pelikortit]: http://freedesignfile.com/22755-different-playing-card-vector-graphic-02/
