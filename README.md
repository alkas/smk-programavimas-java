
## Savarankiškas darbas

### 1 etapas

a) Sumodeliuokite bankomato struktūrą:

| Klasės   | Savybės                   |
|----------|---------------------------|
| Bank     | name(get, set)            |
|  Account | number(get, set)<br/>pin(get, set)<br/>balance(get) |
| ATM | idNumber(get, set)<br/>address (get, set) |

Sukurkite vieną Bank klasės objektą, du Account klasės objektus ir tris objektus - ATM, nustatyti reikšmes savybėms ir išvesti į ekraną.

b) Tarpusavyje susiekite klases Bank, Account ir ATM, kad kiekvienas bankas turėtų sąskaitas ir bankomatus, kiekviena sąskaita turėtų informaciją, kokiame banke ji yra, kiekvienas bankomatas – kokį banką jis aptarnauja:
- Į Bank klasę įtraukite savybes accounts (get) (masyvas) ir cashMachines (get) (masyvas). Taip pat sukurti metodus addAccount ir addATM ;
- Į Account klasę pridėkite savybe bank (get). Savybę balance turite apskaičiuoti automatiškai. Sukurti metodus topUpAccount (sum) ir withdraw(sum);
- Į klasę ATM pridėkite savybę bank (get).
  Sukurti vieną klasės Bank objektą, į šį objektą pridėkite dvi sąskaitas ir tris bankomatus. Į ekraną išvesti vienos sąskaitos visą informaciją. Iš šios sąskaitos nuimkite tam tikrą sumą ir vėl parodykite informaciją apie šios sąskaitos būseną ekrane.

c) Į ATM klasę pridėkite metodą withdraw(int pin, double sum), kuris kreipsis į aptarnaujamo bankomato banką, atliks paieška pagal pin kodą ir atliks pinigų išėmimą pagal nurodytą sumą(iškvietus metodą withdraw(sum)). Patikrinkite metodo veikimą.

### 2 etapas

Visos sąskaitos yra dviejų tipų:
- įprastos;
- lengvatinės.

a) Reikia realizuoti metodą withdraw (išsiimti iš sąskaitos (suma)) taip, kad nuimant tam tikrą
sumą iš įprastos sąskaitą papildomai būtu nuskaičiuoti 5% nuo nurodytos sumos, o atsiimant iš lengvatinės
sąskaitos – tik 1%.
Tam reikia:
- Account klasę padaryti abstrakčia; (1)
- Account klasėje pridėti abstraktų metodą withdraw(sum); (1)
- sukurti dvi išvestines klases RegularAccount ir PreferentialAccount, paveldimas iš Account;
(1)
- RegularAccount ir PreferentialAccount klasėse užkloti withdraw(sum) metodą. (2)
Pridėkite dvi įprastas ir dvi lengvatines sąskaitas prie konkretaus banko ir nustatyti reikšmes. Parodykite
kiekvienos sąskaitos likutį nurodytame banke, tada išimkite iš kiekvienos sąskaitos tam tikrą sumą ir vėl
parodykite kiekvienos sąskaitos likutį. (3)

b) Surikiuokite sąskaitas pagal likutį didėjimo tvarka. Gautą rezultatą išveskite į ekraną. (2)

### 3 etapas

a) Perdaryti savo savarankišką užduotį panaudojant mažiausiai dvi kolekcijas (4 balai (rikiavimas, pridėjimas)).
b) Iš kolekcijos  pašalinti pasirinktą elementą (2 balai).
c) Kolekcijoje pakeisti pasirinktą elementą (2 balai).
d) Panaudoti dar du norimus kolekcijos metodus (2 balai)

### 4 etapas

Pakoreguokite savo individualios užduoties kodą. Pradiniai duomenys yra tekstiniame faile. Rezultatų faile
pradiniai duomenys ir apskaičiuoti atsakymai pateikiami lentelėmis.

a) Sukurti Read klasę, kurioje bus skaitymo metodas. (2)
Nuskaityme turite atsižvelgti į išvetinias klases. Pagrindinėje klasėje turi atsirasti papildomas
kintamasis(mano pavyzdyje typeOfWork). Jeigu bus per sunku su paveldėjimu, naikinate jį. Tokiu atveju -2
balai nuo visos uždoties..

- Sukurkite Print klasę, kurioje bus visi spausdinimo metodai. (2)
- Sukurkite Calculation klasę, kurioje bus visi skaičiavimai.
- Pagrindinę klasę (mano pavyzdyje Firm) pakeiskite į Record. (0,5)
- Surikiuokite duomenis pagal pasirinktą vieną kriterijų ir atspausdinkite.(1)
- Pašalinkite iš sąrašo norimą elementą. Atspausdinkite naują sąrašą.(1)
- Sąraše suraskite pasirinktą elementą ir pakeiskite vieno iš jo kintamųjų reikšmę, bei atspausdinkite tą
elementą.(1)
- Vieną pasirinką konstruktorių, metodą ar klasę padarykite generic.(0,5)
- Sudarykite naują sąrašą sugrupuodami duomenis pagal pasirinktą kriterijų(mano pavydyje pagal
Departament) be pasikartojimų ir sukurkite vieną bendrą kintamąjį. Naudoti Map kolekciją.(2)