# Design Document: Java OOP Reference Solutions

**Datum**: 2026-09-06  
**Status**: Geïmplementeerd  
**Aanpak**: A - Volledige referentie-implementaties

## Samenvatting

Dit document beschrijft het ontwerp van 10 Java OOP-oefeningen die studenten leren over verantwoordelijkheid en delegatie in objectgeoriënteerd programmeren.

## Gekozen aanpak: Approach A

Volledige referentie-oplossingen met:
- Werkende Java-code
- Demo Main.java per opdracht (zonder Scanner)
- Uitgebreide documentatie (VERANTWOORDELIJKHEID.md)
- Mermaid klassendiagrammen
- EDGE CASE commentaar

## Mappenstructuur

```
/
├── README.md
├── docs/superpowers/specs/
│   └── 2026-09-06-java-oop-reference-solutions-design.md
└── referentie-oplossingen/
    ├── README.md
    ├── opdracht-01-bioscoop/
    │   ├── Movie.java
    │   ├── Ticket.java
    │   ├── Cinema.java
    │   ├── Main.java
    │   └── VERANTWOORDELIJKHEID.md
    ├── opdracht-02-huisdier/
    │   └── ...
    └── ... (tot opdracht-10-pretpark)
```

## EDGE CASE Bonus

Alle edge cases zijn gemarkeerd met het formaat:
```java
// EDGE CASE: <wat checken / verzekeren / voorkomen>
```

Voorbeelden:
- Negatieve waarden normaliseren naar 0 of minimum
- Null-checks voor object parameters
- Dubbele acties voorkomen (bijv. ticket hergebruik)
- Grenswaarden correct afhandelen

## Delegatietabel per opdracht

### Opdracht 1: Bioscoop

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| Cinema | Ticket | getPrice() | Wat kost dit ticket? |
| Ticket | Movie | getTicketPrice() | Wat is de ticketprijs? |

### Opdracht 2: Huisdier

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| VeterinaryClinic | Pet | hasAdultOwner() | Is eigenaar volwassen? |
| Pet | Owner | isAdult() | Ben je 18+? |

### Opdracht 3: Game

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| Player | Weapon | getDamage() | Hoeveel schade? |
| Player | Enemy | takeDamage(int) | Verwerk deze schade |

### Opdracht 4: Restaurant

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| Restaurant | Order | calculateTotal() | Wat is het besteltotaal? |
| Order | OrderItem | calculateTotal() | Wat is het regeltotaal? |
| OrderItem | Dish | getPrice() | Wat kost dit gerecht? |

### Opdracht 5: School

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| School | Student | calculateAverage() | Wat is het gemiddelde? |
| Student | Grade | getValue(), isPassing() | Cijferwaarde, voldoende? |
| Grade | Course | getName() | Vaknaam? |

### Opdracht 6: Hotel

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| Hotel | Booking | calculateTotal() | Wat kost de boeking? |
| Booking | Room | getPricePerNight(), markAsBooked() | Prijs, bezet markeren |

### Opdracht 7: Webshop

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| Customer | ShoppingCart | calculateTotal() | Winkelwagentotaal? |
| ShoppingCart | ShoppingCartItem | calculateLineTotal() | Regeltotaal? |
| ShoppingCartItem | Product | getPrice(), hasStockFor(int) | Prijs, voorraadcheck |

### Opdracht 8: Bibliotheek

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| Library | Loan | start(), finish(), isOverdue() | Uitleen starten/stoppen |
| Loan | Book | lend(), returnBook() | Beschikbaarheid aanpassen |

### Opdracht 9: Bezorgdienst

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| DeliveryService | Delivery | calculatePrice() | Bezorgkosten? |
| Delivery | Package | isHeavy() | Is pakket zwaar? |
| Delivery | Address | getFullAddress() | Volledig adres? |

### Opdracht 10: Pretpark

| Van | Naar | Methode | Vraag/Taak |
|-----|------|---------|------------|
| ThemePark | Ticket | isUsed(), use() | Ticket geldig? Gebruik ticket |
| ThemePark | Attraction | allowsVisitor(Visitor) | Mag bezoeker erin? |
| Attraction | Visitor | getAge() | Leeftijd voor check |

## Ontwerpprincipes

### 1. Encapsulation
- Alle velden zijn `private`
- Getters alleen waar nodig voor externe toegang
- Setters vermijden waar mogelijk

### 2. Single Responsibility
- Elke klasse heeft één duidelijke verantwoordelijkheid
- Methodes beantwoorden vragen OF voeren taken uit

### 3. Delegation
- Objecten vragen informatie aan de objecten die deze bezitten
- Geen "verantwoordelijkheid stelen" via externe getters/setters

### 4. Information Hiding
- Interne state wordt beschermd
- Invarianten worden door de eigenaar beheerd

## Filosofie

```
┌────────────────────────────────────────────────────────────┐
│                                                            │
│   Primitieven (int, String, boolean, double)               │
│   = Wat ik van MEZELF weet                                 │
│                                                            │
├────────────────────────────────────────────────────────────┤
│                                                            │
│   Object-typed velden (Movie movie, List<Item> items)      │
│   = Aan wie ik vragen kan stellen / delegeren              │
│                                                            │
├────────────────────────────────────────────────────────────┤
│                                                            │
│   Methodes                                                 │
│   = Vragen die ik kan beantwoorden                         │
│   = Taken die ik kan uitvoeren                             │
│                                                            │
└────────────────────────────────────────────────────────────┘
```

## Technische keuzes

| Aspect | Keuze | Reden |
|--------|-------|-------|
| Taal | Java | Doeltaal voor studenten |
| Dependencies | Geen (plain JDK) | Eenvoud, geen setup nodig |
| Collections | ArrayList | Meest gebruikte List-implementatie |
| Naamgeving | Engels (code), Nederlands (docs) | Internationale code conventies |
| Input | Geen Scanner | Demo's draaien zonder interactie |

## Validatie

Elke opdracht is gevalideerd door:
1. `javac *.java` - Compileert zonder fouten
2. `java Main` - Draait en produceert verwachte output
3. EDGE CASE scenarios in Main.java gedemonstreerd

## Toekomstige uitbreidingen

Mogelijke verbeteringen:
- JUnit tests toevoegen
- Gradle/Maven build configuratie
- Javadoc documentatie
- UML export van Mermaid diagrammen
