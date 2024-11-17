# Repository për lëndën "Siguria e Informacionit" të studimeve Master.

Ky repository përmban projektin për lëndën e Sigurisë së Informacionit - FIEK, Universiteti i Prishtinës "Hasan Prishtina". Profesori i lëndës është Prof. Dr. Blerim Rexha, ndërsa asistenti është Dr. Sc. Mërgim Hoti.

# Autorët
Erëblina Berisha, 
Kaltrinë Baliu dhe
Njomza Rexhepi

# Projekti: Gjenerimi i QR Code me Nënshkrime Digjitale Duke Përdorur EdDSA

Ky projekt tregon gjenerimin e një kodi QR me nënshkrime digjitale duke përdorur algoritmin EdDSA (Edwards-curve Digital Signature Algorithm) në Java. Projekti thekson implementimin e teknikave kriptografike për të siguruar autenticitetin dhe integritetin e kodit QR, i cili shpesh përdoret në sisteme të sigurta komunikimi dhe verifikimi të identitetit.

# EdDSA

EdDSA (Edwards-curve Digital Signature Algorithm) është një algoritëm modern dhe i sigurt për nënshkrime digjitale, i bazuar në kurba eliptike të optimizuara për performancë, siç janë kurba 255-bit Curve25519 dhe 448-bit Curve448-Goldilocks. Nënshkrimet EdDSA përdorin formën Edwards të kurbave eliptike (për arsye performancë), përkatësisht edwards25519 dhe edwards448. Algoritmi EdDSA bazohet në algoritmin e nënshkrimit Schnorr dhe mbështetet në vështirësinë e problemit ECDLP (Elliptic Curve Discrete Logarithm Problem).

# Teknologjitë dhe Mjetet
Java: Gjuha kryesore e programimit e përdorur për implementimin e algoritmit të nënshkrimit digjital EdDSA.

EdDSA: Një skemë moderne e nënshkrimit bazuar në kurba eliptike, e njohur për sigurinë dhe efikasitetin e saj të lartë.

Gjenerimi i QR Code: Biblioteka për gjenerimin dhe kodimin e kodeve QR që do të mbajnë të dhënat e nënshkruara.


# Libraritë e përdorura: 
BouncyCastle</br>
BouncyCastle është një bibliotekë për kriptografinë dhe sigurinë. Këto klasa ofrojnë mbështetje për funksionalitete të avancuara kriptografike, duke përfshirë:
Gjenerimin e çelësave (KeyPair).
Algoritmet e nënshkrimit (Signatures).
Kodim/enkodim (p.sh., Hex për të kthyer të dhënat binare në format heksadecimal).

java.security</br>
Ofrojnë funksione themelore për operacionet kriptografike si:
Gjenerimi i çelësave publikë dhe privatë.
Menaxhimi i nënshkrimeve dixhitale.
Konfigurimi i ofruesve të sigurisë (p.sh., shtimi i BouncyCastle si provider).

ZXing</br>
ZXing (Zebra Crossing) është një bibliotekë për krijimin dhe leximin e kodeve bardhezi, përfshirë QR-kodet.
QRCodeWriter: Gjeneron QR-kode në formën e matricave binare.
BitMatrix: Struktura që përfaqëson QR-kodin në mënyrë digjitale.
MatrixToImageWriter: Kthen matricën binare në një imazh (p.sh., PNG).


javax.imageio</br>
ImageIO</br>
Përdorimi: Ofrohet nga Java për të lexuar dhe shkruar formate të ndryshme imazhesh (p.sh., PNG, JPEG).
Pse përdoret: Në këtë rast, përdoret për të ruajtur imazhin QR-kod në disk si skedar.

# Si të ekzekutoni aplikacionin:
Fillimisht duhet të keni të instaluar Eclipse dhe Java në versionin e fundit, instalimi i librarive të lartë përmendura.

Pasi që të ekzekutoni aplikacionin përkatës do të gjenerohet QRCode.png si në foton më poshtë.

![image](https://github.com/user-attachments/assets/a36bc2f2-151e-4778-b717-22cc5ee18d39)
