import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("weather.csv")
df["Date"] = pd.to_datetime(df["Date"])
print("Hottest Day:", df.loc[df["Temperature"].idxmax()]["Date"].date())
print("Coldest Day:", df.loc[df["Temperature"].idxmin()]["Date"].date())
df["Month"] = df["Date"].dt.month
monthly_avg = df.groupby("Month")["Temperature"].mean()
plt.bar(df["Date"], df["Temperature"])
plt.xticks(rotation=90)
plt.ylabel("Temperature")
plt.title("Daily Temperatures")
plt.tight_layout()
plt.show()

plt.bar(monthly_avg.index.astype(str), monthly_avg.values)
plt.xlabel("Month")
plt.ylabel("Avg Temperature")
plt.title("Monthly Average Temperature")
plt.tight_layout()
plt.show()
