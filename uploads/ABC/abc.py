import pandas as pd
import matplotlib.pyplot as plt

df=pd.read_csv("employee1.csv")#employee data, take ppl joined b4 2020 then count them sort them cpuntvs year
df.dropna(subset=['yoj'],inplace=True)#remove missing values too
df['date']=pd.to_datetime(df['yoj'])
df=df[df['date'].dt.year<2020] # updating a dataframe with segment of df consisting of df values <2020
df['year']=df['date'].dt.year
year_count=df['year'].value_counts().sort_values()
year_count.plot(kind='bar')
plt.xlabel('YEAR')
plt.ylabel('COUNT')
plt.tight_layout()
plt.show()
