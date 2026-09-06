# Referentie-oplossingen OOP Opdrachten

Dit zijn de referentie-oplossingen voor 10 OOP-oefeningen over verantwoordelijkheid en delegeren in Java.

## Compileren en uitvoeren

Elke opdracht kan apart gecompileerd en uitgevoerd worden. Navigeer naar de map van de opdracht en voer de volgende commando's uit:

```bash
# Compileer alle Java-bestanden
javac *.java

# Voer het programma uit
java Main
```

### Voorbeeld voor opdracht 1 (Bioscoop):

```bash
cd opdracht-01-bioscoop
javac *.java
java Main
```

## Overzicht opdrachten

| Nr | Naam | Thema | Klassen |
|----|------|-------|---------|
| 01 | Bioscoop | Ticket delegeert prijs aan Movie | Movie, Ticket, Cinema |
| 02 | Huisdier | Kliniek delegeert volwassen-check via Pet aan Owner | Owner, Pet, VeterinaryClinic |
| 03 | Game | Player delegeert schade aan Weapon, Enemy beheert eigen health | Weapon, Player, Enemy |
| 04 | Restaurant | Order sommeert via OrderItem, die delegeert aan Dish | Dish, OrderItem, Order, Restaurant |
| 05 | School | Grade bepaalt zelf voldoende, Student telt via delegatie | Course, Grade, Student, School |
| 06 | Hotel | Booking delegeert aan Room voor prijs en beschikbaarheid | Guest, Room, Booking, Hotel |
| 07 | Webshop | Product beheert voorraad, ShoppingCart delegeert via items | Product, ShoppingCartItem, ShoppingCart, Customer |
| 08 | Bibliotheek | Book markeert zichzelf als uitgeleend/teruggebracht | Book, Member, Loan, Library |
| 09 | Bezorgdienst | Package bepaalt zelf of het zwaar is, Delivery delegeert | Address, Package, Delivery, DeliveryService |
| 10 | Pretpark | ThemePark delegeert leeftijdscheck aan Attraction | Visitor, Attraction, Ticket, ThemePark |

## Structuur per opdracht

Elke opdracht-map bevat:
- **Java-bestanden**: Eén public class per bestand
- **Main.java**: Demo-programma zonder Scanner (geen user input)
- **VERANTWOORDELIJKHEID.md**: Documentatie over verantwoordelijkheden en delegatieketens

## Filosofie

Deze oplossingen volgen de principes van verantwoordelijkheid en delegatie:

- **Primitieven** = wat ik van mezelf weet (name, age, price, etc.)
- **Object-typed velden** = aan wie ik vragen kan stellen of taken kan delegeren
- **Methodes** = vragen die ik kan beantwoorden of taken die ik kan uitvoeren

### Belangrijke regels:

1. **Private fields**: Alle velden zijn private
2. **Getters/setters**: Alleen waar nodig
3. **Delegatie**: Vraag aan het object dat de informatie bezit
4. **Geen verantwoordelijkheid stelen**: Pas nooit de invarianten van een ander object aan via getters/setters

## EDGE CASE Comments

De code bevat commentaar in het formaat:
```java
// EDGE CASE: <wat checken / verzekeren / voorkomen>
```

Dit markeert plekken waar speciale situaties worden afgehandeld, zoals:
- Negatieve waarden voorkomen
- Null-checks uitvoeren
- Dubbele acties voorkomen (bijv. ticket twee keer gebruiken)
- Grenswaarden controleren
