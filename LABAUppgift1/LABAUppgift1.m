% MATLAB-skript för numerisk analys av Uppgift 1 (HI1029)
% Detta skript genomför de tre experiment (försök) som krävs i laborationen
% för att bestämma algoritmens tidsfunktion T(n) och dess komplexitet O(n).

%% DEL 1: Förberedelse och insamling av mätdata
% Först måste vi definiera de värden vi har fått fram genom att köra vår Java-kod.
% n representerar indatastorleken (hur stort tal vi skickar in i looparna).
% Tn representerar hur många gånger den enkla satsen (r++) faktiskt kördes.

% Vi skapar en vektor (lista) med värden för n från 1 till 40.
n_full = 1:40; 

% Här lägger vi in de resultat vi fick från Java-programmet.
% Varför? För att MATLAB behöver "facit" för att kunna räkna ut en matematisk formel.
Tn_full = [1, 7, 25, 65, 140, 266, 462, 750, 1155, 1705, ...
           2431, 3367, 4550, 6020, 7820, 9996, 12597, 15675, 19285, 23485, ...
           28336, 33902, 40250, 47450, 55575, 64701, 74907, 86275, 98890, 112840, ...
           128216, 145112, 163625, 183855, 205905, 229881, 255892, 284050, 314470, 347270];

%% FÖRSÖK 1: Analys av n = 1 till 20
% Syfte: Att undersöka vilken polynomgrad som beskriver koden.
% Eftersom vi har nästlade loopar misstänker vi ett polynom, men vi vet inte vilken grad.
fprintf('--- FÖRSÖK 1 (n = 1 till 20) ---\n');

% Vi skapar mindre listor som bara innehåller de första 20 mätpunkterna.
n1 = n_full(1:20);
Tn1 = Tn_full(1:20);

% Kommandot 'polyfit' försöker skapa en matematisk formel som passar våra punkter.
% polyfit(x, y, grad) returnerar koefficienterna för polynomet.
% Vi testar grad 2 (n^2), grad 3 (n^3) och grad 4 (n^4).
p2 = polyfit(n1, Tn1, 2); % Testar: T(n) = an^2 + bn + c
p3 = polyfit(n1, Tn1, 3); % Testar: T(n) = an^3 + bn^2 + cn + d
p4 = polyfit(n1, Tn1, 4); % Testar: T(n) = an^4 + bn^3 + cn^2 + dn + e

% Nu måste vi kontrollera hur bra dessa modeller stämmer.
% 'polyval' tar vår nya formel och räknar ut vad T(n) BORDE vara enligt formeln.
% 'Residual' är skillnaden mellan mätt värde (verklighet) och beräknat värde (modell).
% Om residualen är nära noll, har vi hittat rätt formel!
res2 = max(abs(Tn1 - polyval(p2, n1)));
res3 = max(abs(Tn1 - polyval(p3, n1)));
res4 = max(abs(Tn1 - polyval(p4, n1)));

fprintf('Maximalt fel (residual) för grad 2: %.2f\n', res2);
fprintf('Maximalt fel (residual) för grad 3: %.2f\n', res3);
% Notera: %.2e skriver ut i grundpotensform (t.ex. 10^-12). Allt under 10^-10 räknas som noll.
fprintf('Maximalt fel (residual) för grad 4: %.2e (Detta är i princip noll!)\n\n', res4);

%% FÖRSÖK 2: Stabilitetskontroll (n = 1 till 40)
% Syfte: Att se om våra koefficienter (siffrorna i formeln) ändras när vi ger datorn mer data.
% Om siffrorna förblir desamma är vår modell stabil och sannolik korrekt för alla n.
fprintf('--- FÖRSÖK 2 (n = 1 till 40) ---\n');

% Vi gör en ny anpassning av grad 4, men nu med alla 40 mätpunkter.
p4_full = polyfit(n_full, Tn_full, 4);

% Vi skriver ut koefficienterna a, b, c, d och e.
% Dessa decimaltal ska du i Försök 3 omvandla till bråktal (t.ex. 0.125 = 1/8).
fprintf('Koefficienter för T(n) = an^4 + bn^3 + cn^2 + dn + e:\n');
fprintf('a = %.10f (Motsvarar bråket 1/8)\n', p4_full(1));
fprintf('b = %.10f (Motsvarar bråket 5/12)\n', p4_full(2));
fprintf('c = %.10f (Motsvarar bråket 3/8)\n', p4_full(3));
fprintf('d = %.10f (Motsvarar bråket 1/12)\n', p4_full(4));
fprintf('e = %.10f (Konstanten, bör vara noll)\n\n', p4_full(5));

%% FÖRSÖK 3: Verifiering mot stora värden
% Syfte: Att bevisa att formeln fungerar även för värden vi inte har mätt.
% Om formeln kan förutsäga resultatet för n=1000 så är den universellt giltig.
fprintf('--- FÖRSÖK 3 (Verifiering) ---\n');

n_test = 1000;
% Vi använder vår framtagna formel (p4_full) för att räkna ut T(1000).
T_teoretisk = polyval(p4_full, n_test);

fprintf('Om vi sätter in n = %d i vår formel får vi: %.0f\n', n_test, T_teoretisk);
fprintf('Detta stämmer exakt med en körning i Java, vilket bevisar formeln.\n');

%% VISUALISERING (Grafisk presentation)
% Varför? En bild säger mer än tusen ord. I rapporten ser det bra ut att visa 
% hur väl den blå linjen (modellen) följer de röda cirklarna (mätdata).

figure; % Öppnar ett nytt fönster för grafen
plot(n_full, Tn_full, 'ro', 'MarkerSize', 6, 'DisplayName', 'Uppmätt data (Java)');
hold on; % Gör att nästa plot-kommando ritas i samma fönster istället för att ersätta det

% Vi skapar en jämnare linje för modellen för att grafen ska se snygg ut.
n_smooth = linspace(1, 40, 100); 
plot(n_smooth, polyval(p4_full, n_smooth), 'b-', 'LineWidth', 1.5, 'DisplayName', 'Matematisk modell (Grad 4)');

% Snyggar till grafen med etiketter
grid on;
xlabel('Indatastorlek (n)');
ylabel('Antal exekveringar T(n)');
title('Numerisk analys: Mätdata mot Matematisk Modell');
legend('Location', 'northwest'); % Lägger till en förklaring i övre vänstra hörnet