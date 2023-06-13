#!/usr/bin/env python
# coding: utf-8

# In[3]:


#Amortissement
#import numpy as np
 
#Saisi
emprunt=int(input('Montant= '))
duree=int(input('Durée= '))
taux=int(input('Taux= '))

 
#Formules
amortissement = emprunt / duree
annuite = amortissement + interet
valeur_nette = emprunt_restant_du - amortissement
interet = (emprunt_restant_du * taux) / 100
#emprunt_restant_du = 
 
#Entete
#ligne1=["Année","Emprunt Restant Dû", "Intérêt, Amortissement", "Annuité", "Valeur Nette"]
#print(ligne1)
 
#Affichage année
a = 1
while a < duree + 1:
    a = a +1
    print ("annee" ,a)
    


# In[ ]:




