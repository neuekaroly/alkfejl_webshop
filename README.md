# Játék webáruház

Egy konzol és PC-s játékokat árusító cég online webáruháza. A weboldalon keresztül a felhasználók játékokat tudnak rendelni. 

## Funkcionális követelmények
- Minden oldalon megjelenik egy kereső, ahol a termékek között lehet böngészni
- Lehetőség nyílik platform szerint szűkíteni a keresést
- A felhasználó szűkítheti a keresését ár, megjelenés, kategória szerint
- Egy oldalon legfeljebb 25 termék jelenik meg, az címével, árával, gyártóval és megjelenési dátumával
- Egy termékre kattintva megjelenik a részletes leírása, gépigénye stb.
- A felhasználó kosarába tudja helyezni a kiválasztott terméket, akár egyszerre többet is
- A kosárból a termékek bármikor törölhetőek, illetve darabszámot is adhat meg
- A rendelés előtt a felhasználó még egyszer áttekintheti a kosár tartalmát
- Adatai leadásával vagy regisztrált felhasználó esetén bejelentkezéssel adhatja le a rendelését(feltéve ha megadott minden szükséges adatot)
- A regisztráció során a rendszer elmenti az adatokat, és azok helyes megadásával a felhasználó később bejelentkezhet a rendszerbe
- Lehetőség van kupon beváltására is, ezt a felhasználónak a rendelése leadása során jeleznie kell
- A főoldalon megjelenek a legújabb illetve a legkeresettebb játékok is
- Lehetőség van bankkártyás és utánvételes fizetésre is

## Nem funkcionális követelmények
- A weboldalt a felhasználó tetszőleges böngészőből tudja elérni
- Számítógépen, mobiltelefonon és tableten is megfelelően jelenik meg
- A regisztrált felhasználók adatait más felhasználó nem érheti el
- A jelszavak mentésére hashellést használ a rendszer
- A fejlesztés során használt technológiák:
	- Java Spring Boot
	- HTML
	- CSS (Material)
	- H2 adatbázisrendszer
	- Angular JS
	- Typescript
	
## Szerepkörök
- Adminisztrátor: frissítheti az adatbázis illetve felhasználókat törölhet a rendszerből, megtekintheti a a felhasználók által leadott rendeléseket és moderálhatja a termék értékeléseket
- Felhasználó: rendeléseket adhat le és nyomon követheti azokat, értkelheti a terméket
- Látogató: nem regisztrált, de ugyanúgy rendelhet, viszont értékelést nem írhat
