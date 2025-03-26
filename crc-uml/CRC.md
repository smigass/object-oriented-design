# Karty CRC - Lab1

## Autorzy: Szymon Migas, Emil Siatka

---

## Game

<table style="width: 100%">
  <tr style="width: 100%">
    <td colspan="2" style="text-align: center;"><strong>Game</strong></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Zarządza przebiegiem gry<br>- Śledzi pozycje graczy<br>- Zarządza rundami i turami<br>- Pozwala na ruch graczy</td>
    <td>- Player<br>- Round<br>- Vector2D</td>
  </tr>
</table>

---

## Vector2D

<table>
  <tr>
    <td colspan="2" style="text-align: center;"><strong>Vector2D</strong></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Reprezentuje współrzędne (x, y)</td>
    <td>- Game (do śledzenia pozycji graczy)</td>
  </tr>
</table>

<div style="page-break-before: always;"></div>

## Player

<table>
  <tr>
    <td colspan="2" style="text-align: center;"><strong>Player</strong></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Przechowuje statystyki postaci (siła, mana, zdrowie, doświadczenie)<br>- Posiada ekwipunek i broń<br>- Może atakować<br>- Zyskuje doświadczenie</td>
    <td>- Equipment<br>- Weapon<br>- Round</td>
  </tr>
</table>

---

## Equipment

<table>
  <tr>
    <td colspan="2" style="text-align: center;"><strong>Equipment</strong></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Zarządza przedmiotami<br>- Pozwala na ekwipowanie przedmiotów</td>
    <td>- Equipable<br>- Player</td>
  </tr>
</table>

---

## Weapon

<table>
  <tr>
    <td colspan="2" style="text-align: center;"><strong>Weapon</strong></td>
  </tr>
   <tr>
    <td><strong><i>Implementuje</i></strong></td>
    <td><i><strong>Equipable</i></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Przechowuje informacje o broni (nazwa, obrażenia, zajmowane sloty)<br>- Pozwala uzyskać obrażenia broni</td>
    <td>- Player</td>
  </tr>
</table>

---

## Armor

<table>
  <tr>
    <td colspan="2" style="text-align: center;"><strong>Armor</strong></td>
  </tr>
  <tr>
    <td><strong><i>Implementuje</i></strong></td>
    <td><i><strong>Equipable</i></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Przechowuje informacje o zbroi (nazwa, pancerz, zajmowane sloty)<br>- Pozwala uzyskać wartość pancerza</td>
    <td>- Player</td>
  </tr>
</table>

---

## Shield

<table>
  <tr>
    <td colspan="2" style="text-align: center;"><strong>Shield</strong></td>
  </tr>
   <tr>
    <td><strong><i>Implementuje</i></strong></td>
    <td><i><strong>Equipable</i></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Przechowuje informacje o tarczy (nazwa, pancerz, zajmowane sloty)<br>- Pozwala uzyskać wartość obrony</td>
    <td>- Player</td>
  </tr>
</table>

---

## SpellsEngine

<table>
  <tr>
    <td colspan="2" style="text-align: center;"><strong>SpellsEngine</strong></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Przechowuje dostępne czary<br>- Losuje czar na podstawie statystyk postaci</td>
    <td>- Spell<br>- Round</td>
  </tr>
</table>

---

## Spell

<table>
  <tr>
    <td colspan="2" style="text-align: center;"><strong>Spell</strong></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Przechowuje moc czaru oraz koszt many<br>- Pozwala uzyskać moc czaru i koszt many</td>
    <td>- SpellsEngine</td>
  </tr>
</table>

---

## Round

<table>
  <tr>
    <td colspan="2" style="text-align: center;"><strong>Round</strong></td>
  </tr>
  <tr>
    <td><strong>Odpowiedzialność</strong></td>
    <td><strong>Współpracownicy</strong></td>
  </tr>
  <tr>
    <td>- Zarządza walką między graczami<br>- Zarządza doświadczeniem</td>
    <td>- Player<br>- SpellsEngine</td>
  </tr>
</table>

---