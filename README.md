# OOP 10 Oefenopdrachten

Referentie-oplossingen voor 10 Java OOP-oefeningen over verantwoordelijkheid en delegeren.

## Snel starten

Navigeer naar een opdracht-map en compileer met:

```bash
cd referentie-oplossingen/opdracht-01-bioscoop
javac *.java
java Main
```

## Projectstructuur

```
├── README.md                          # Dit bestand
├── docs/
│   ├── oop-opdrachten.pdf             # De 10 oefeningen (PDF)
│   └── oop-filosofie-verantwoordelijkheid.pdf  # Verantwoordelijkheidsfilosofie (PDF)
└── referentie-oplossingen/
    ├── README.md                      # Uitgebreide documentatie
    ├── opdracht-01-bioscoop/
    ├── opdracht-02-huisdier/
    ├── opdracht-03-game/
    ├── opdracht-04-restaurant/
    ├── opdracht-05-school/
    ├── opdracht-06-hotel/
    ├── opdracht-07-webshop/
    ├── opdracht-08-bibliotheek/
    ├── opdracht-09-bezorgdienst/
    └── opdracht-10-pretpark/
```

## Documentatie

De volgende PDF-bestanden horen in de `docs/` map:
- **oop-opdrachten.pdf** — De 10 oefeningen met skeletons en requirements
- **oop-filosofie-verantwoordelijkheid.pdf** — De filosofie achter verantwoordelijkheid en delegatie

## Opdrachten overzicht

| Nr | Naam | Beschrijving |
|----|------|--------------|
| 01 | Bioscoop | Film, Ticket en Cinema - prijsdelegatie |
| 02 | Huisdier | Eigenaar, Huisdier en Dierenkliniek - volwassen-check delegatie |
| 03 | Game | Wapen, Speler en Vijand - schade en gezondheidsbeheer |
| 04 | Restaurant | Gerecht, Bestelregel, Bestelling - prijsberekening keten |
| 05 | School | Vak, Cijfer, Student, School - voldoende/gemiddelde delegatie |
| 06 | Hotel | Gast, Kamer, Boeking - beschikbaarheid en kostendelegatie |
| 07 | Webshop | Product, Winkelwagen, Klant - voorraad en totaalberekening |
| 08 | Bibliotheek | Boek, Lid, Uitlening - beschikbaarheidsbeheer |
| 09 | Bezorgdienst | Pakket, Adres, Bezorging - gewichtscheck en prijsformule |
| 10 | Pretpark | Bezoeker, Attractie, Ticket - leeftijdscheck en ticketgebruik |

## Kernprincipes

### Verantwoordelijkheid en Delegatie

```
┌─────────────────────────────────────────────────────────────────┐
│  Primitieven (int, String, double, boolean)                     │
│  → Wat ik van MEZELF weet                                       │
├─────────────────────────────────────────────────────────────────┤
│  Object-typed velden (Movie movie, Owner owner, etc.)           │
│  → Aan wie ik vragen kan stellen of taken kan delegeren         │
├─────────────────────────────────────────────────────────────────┤
│  Methodes                                                       │
│  → Vragen die ik kan beantwoorden OF taken die ik kan uitvoeren │
└─────────────────────────────────────────────────────────────────┘
```

### Regels

1. **Private fields** - Alle velden zijn private
2. **Getters/setters** - Alleen waar echt nodig
3. **Delegeer** - Vraag aan het object dat de informatie bezit
4. **Steel geen verantwoordelijkheid** - Pas nooit invarianten van andere objecten aan

### EDGE CASE Comments

Speciale situaties zijn gemarkeerd met:
```java
// EDGE CASE: <wat checken / verzekeren / voorkomen>
```

## Vereisten

- Java JDK 8 of hoger
- Geen externe dependencies

## Per opdracht

Elke opdracht bevat:
- Java-bronbestanden (één public class per bestand)
- `Main.java` met demo (geen Scanner/user input)
- `UITLEG.md` met:
  - Verantwoordelijkheidstabellen per klasse
  - Delegatieketens
  - Mermaid klassendiagram
