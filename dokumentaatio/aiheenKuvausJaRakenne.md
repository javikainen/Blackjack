##Aihe: Blackjack-peli

Toteutetaan Blackjack-peli graafisella käyttöliittymällä. Jakaja toimii tietokoneen ohjaamana ja pelaa normaalien kasinosääntöjen mukaan. Käyttäjän hallitseman pelaajan lisäksi peliin voi osallistua maksimissaan kaksi tietokoneen ohjaamaa pelaajaa.

####Käyttöliittymä

Peliin rakennetaan yksinkertainen graafinen käyttöliittymä, jossa pelikortit piirretään käyttäen valmiita Public Domain -lisenssin alla olevia pelikortteja (lähde: [http://freedesignfile.com][Pelikortit]). Pelinäkymän lisäksi käyttöliittymässä on toimintopainikkeet pelin aikana valittaville toiminnoille (panoksen valinta sekä Hit ja Stand).

####Määrittelyvaiheen luokkakaavio

![Määrittelyvaiheen luokkakaavio](/dokumentaatio/kuvat/Luokkakaavio.png "Määrittelyvaiheen luokkakaavio")

####Rakennekuvaus

Pelin UI koostuu luokista BlackjackUI, ImageLabel ja CardMap. BlackjackUI sisältää valtaosan käyttöliittymästä ja huolehtii myös pelin etenemisestä. ImageLabel ja CardMap ovat apuluokkia, joita käytetään pelikorttien kuvien varastointiin ja esittämiseen. 

Pelilogiikan ydin on luokka BlackjackLogic, joka pitää kirjaa pelaajista, pelikorteista ja panoksista sekä hoitaa mm. voitonmaksun. Korttipakka, josta jaettavat kortit otetaan, on toteutettu luokassa Shoe. Yksittäiset kortit puolestaan esitetään luokan Card olioina, ja Shoe sisältääkin listan Card-olioita. Toinen luoka Card olioita sisältävä luokka on Hand, joka kuvaa jonkin pelaaja kädessä (tai oikeammin pöydällä) olevia kortteja. Korttien säilömisen lisäksi luokka osaa laske käden pistearvon, sekä mm. kertoa onko kyseessä blackjack.

Kunkin pelaajan tiedot talletetaan johonkin luokan Player alaluokkaan, joita ovat tällä hetkellä HumanPlayer, AIPlayer ja Dealer. Pelaajaluokkien tallettamia tietoja ovat mm. pelaajan nimi, rahatilanne, senhetkinen panos ja kädessä olevat kortit. Tekoälyn ohjaamien pelaajien (ml. Dealer) tehtävänä on myös huolehtia pelaajan pelin aikana tekemistä päätöksistä, kuten panoksen suuruudesta ja siitä, kuinka monta korttia pelaaja nostaa.

####Sekvenssikaavioita käyttötapauksista

![Korttien jakaminen](/dokumentaatio/kuvat/Dealing cards.png "Dealing cards")

![AI pelaa kierroksen](/dokumentaatio/kuvat/Playing AI hand.png "Playing AI hand")

![Voitonmaksu](/dokumentaatio/kuvat/Paying Winnings.png "Paying winnings")

[Pelikortit]: http://freedesignfile.com/22755-different-playing-card-vector-graphic-02/
