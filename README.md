
## Savarankiškas darbas

### 1 etapas

a) Sumodeliuokite bankomato struktūrą:

| Klasės   | Savybės                   |
|----------|---------------------------|
| Bank     | name(get, set)            |
|  Account | number(get, set)<br/>pin(get, set)<br/>balance(get) |
| ATM | idNumber(get, set)<br/>address (get, set) |

b) Sukurkite vieną Bank klasės objektą, du Account klasės objektus ir tris objektus - ATM, nustatyti reikšmes savybėms ir išvesti į ekraną.

b) Tarpusavyje susiekite klases Bank, Account ir ATM, kad kiekvienas bankas turėtų sąskaitas ir bankomatus, kiekviena sąskaita turėtų informaciją, kokiame banke ji yra, kiekvienas bankomatas – kokį banką jis aptarnauja:
- Į Bank klasę įtraukite savybes accounts (get) (masyvas) ir cashMachines (get) (masyvas). Taip pat sukurti metodus addAccount ir addATM ;
- Į Account klasę pridėkite savybe bank (get). Savybę balance turite apskaičiuoti automatiškai. Sukurti metodus topUpAccount (sum) ir withdraw(sum);
- Į klasę ATM pridėkite savybę bank (get).
  Sukurti vieną klasės Bank objektą, į šį objektą pridėkite dvi sąskaitas ir tris bankomatus. Į ekraną išvesti vienos sąskaitos visą informaciją. Iš šios sąskaitos nuimkite tam tikrą sumą ir vėl parodykite informaciją apie šios sąskaitos būseną ekrane.

c) Į ATM klasę pridėkite metodą withdraw(int pin, double sum), kuris kreipsis į aptarnaujamo bankomato banką, atliks paieška pagal pin kodą ir atliks pinigų išėmimą pagal nurodytą sumą(iškvietus metodą withdraw(sum)). Patikrinkite metodo veikimą.

### 2 etapas

