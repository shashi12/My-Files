package com.shashi.android.androidutility;

public class ConverterUtil {

	 // converts to celsius
	  public static float convertFahrenheitToCelsius(float fahrenheit) {
	    return ((fahrenheit - 32) * 5 / 9);
	  }

	  // converts to fahrenheit
	  public static float convertCelsiusToFahrenheit(float celsius) {
	    return ((celsius * 9) / 5) + 32;
	  }
	
	  public static float convertKelvinToFahrenheit(float kelvin) {
		    return (float) ((((kelvin-273.15)* 9) / 5) + 32);
		  }
	  public static float convertKelvinToCelsius(float kelvin) {
		    return (float) (kelvin-273.15);
		  }
	  
	  public static float convertCelsiusToKelvin(float celsius) {
		    return (float) (celsius +273.15);
		  }
	  
	  public static float convertFahrenheitToKelvin(float fahrenheit) {
		    return (float) (((fahrenheit - 32) * 5 / 9)+273.15);
		  }
	 //Length: kilometer 
	  public static float convertKilometerToMeter(float kilometer) {
		    return (float) (kilometer*1000);
		  }
	  public static float convertKilometerTocentiMeter(float kilometer) {
		    return (float) (kilometer*100000);
		  }
	  public static float convertKilometerTomilliMeter(float kilometer) {
		    return (float) (kilometer*1000000);
		  }
	  public static float convertKilometerToMile(float kilometer) {
		    return (float) (kilometer*0.621371);
		  }
	  public static float convertKilometerToYard(float kilometer) {
		    return (float) (kilometer*1093.61);
		  }
	  public static float convertKilometerToFoot(float kilometer) {
		    return (float) (kilometer*3280.84);
		  }
	  public static float convertKilometerToInch(float kilometer) {
		    return (float) (kilometer*39370.1);
		  }
	  public static float convertKilometerToNauticleMile(float kilometer) {
		    return (float) (kilometer*0.539957);
		  }
	  
	  //Length: Meter 
	  public static float convertMeterToKilometer(float meter) {
		    return (float) (meter*0.001);
		  }
	  public static float convertMeterTocentiMeter(float meter) {
		    return (float) (meter*100);
		  }
	  public static float convertMeterTomilliMeter(float meter) {
		    return (float) (meter*1000);
		  }
	  public static float convertMeterToMile(float meter) {
		    return (float) (meter*0.000621371);
		  }
	  public static float convertMeterToYard(float meter) {
		    return (float) (meter*1.09361);
		  }
	  public static float convertMeterToFoot(float meter) {
		    return (float) (meter*3.28084);
		  }
	  public static float convertMeterToInch(float meter) {
		    return (float) (meter*39.3701);
		  }
	  public static float convertMeterToNauticleMile(float meter) {
		    return (float) (meter*0.000539957);
		  }


	//Length: CentiMeter 
	  public static float convertCentimeterToKilometer(float centimeter) {
		    return (float) (centimeter*0.000001);
		  }
	  
	  public static float convertCentimeterTometer(float centimeter) {
		    return (float) (centimeter*0.01);
		  }
	  public static float convertCentimeterTomilliMeter(float centimeter) {
		    return (float) (centimeter*10);
		  }
	  public static float convertCentimeterToMile(float centimeter) {
		    return (float) (centimeter*6.21371*.0000001);
		  }
	  public static float convertCentimeterToYard(float centimeter) {
		    return (float) (centimeter*0.0109361);
		  }
	  public static float convertCentimeterToFoot(float centimeter) {
		    return (float) (centimeter*0.0328084);
		  }
	  public static float convertCentimeteroInch(float centimeter) {
		    return (float) (centimeter*0.393701);
		  }
	  public static float convertCentimeterToNauticleMile(float centimeter) {
		    return (float) (centimeter*5.3996*.0000001);
		  }

	//Length: Millimeter 
	  public static float convertMillimeterToKilometer(float Millimeter) {
		    return (float) (Millimeter*0.0000001);
		  }
	  
	  public static float convertMillimeterTometer(float Millimeter) {
		    return (float) (Millimeter*0.001);
		  }
	  public static float convertMillimeterTocentiMeter(float Millimeter) {
		    return (float) (Millimeter*0.1);
		  }
	  public static float convertMillimeterToMile(float Millimeter) {
		    return (float) (Millimeter*6.21371*.00000001);
		  }
	  public static float convertMillimeterToYard(float Millimeter) {
		    return (float) (Millimeter*0.00109361);
		  }
	  public static float convertMillimeterToFoot(float Millimeter) {
		    return (float) (Millimeter*0.00328084);
		  }
	  public static float convertMillimeterToInch(float Millimeter) {
		    return (float) (Millimeter*0.0393701);
		  }
	  public static float convertMillimeterToNauticleMile(float Millimeter) {
		    return (float) (Millimeter*5.3996*.00000001);
		  }

	//Length: Mile 
	  public static float convertMileToKilometer(float Mile) {
		    return (float) (Mile*1.60934);
		  }
	  public static float convertMileTometer(float Mile) {
		    return (float) (Mile*1609.34);
		  }
	  public static float convertMilemeterTocentiMeter(float Mile) {
		    return (float) (Mile*160934);
		  }
	  public static float convertMileToMillimeter(float Mile) {
		    return (float) (Mile*1.609*.0000001);
		  }
	  public static float convertMileToYard(float Mile) {
		    return (float) (Mile*1760);
		  }
	  public static float convertMileToFoot(float Mile) {
		    return (float) (Mile*5280);
		  }
	  public static float convertMileToInch(float Mile) {
		    return (float) (Mile*63360);
		  }
	  public static float convertMileToNauticleMile(float Mile) {
		    return (float) (Mile*0.868976);
		  }
  
	  
	//Length: Yard 
	  public static float convertYardToKilometer(float Yard) {
		    return (float) (Yard*0.0009144);
	  }  
	  public static float convertYardTometer(float Yard) {
		    return (float) (Yard*0.9144);
		  }
	  public static float convertYardTocentiMeter(float Yard) {
		    return (float) (Yard*91.44);
		  }
	  public static float convertYardToMillimeter(float Yard) {
		    return (float) (Yard*914.4);
		  }
	  public static float convertYardToMile(float Yard) {
		    return (float) (Yard*0.000568182);
		  }
	  public static float convertYardToFoot(float Yard) {
		    return (float) (Yard*3);
		  }
	  public static float convertYardToInch(float Yard) {
		    return (float) (Yard*36);
		  }
	  public static float convertYardToNauticleMile(float Yard) {
		    return (float) (Yard*0.000493737);
		  }
  
	  
	//Length: Foot 
	  public static float convertFootToKilometer(float Foot) {
		    return (float) (Foot*0.0003048);
		  }	  
	  public static float convertFootTometer(float Foot) {
		    return (float) (Foot*0.3048);
		  }
	  public static float convertFootTocentiMeter(float Foot) {
		    return (float) (Foot*30.48);
		  }
	  public static float convertFootToMillimeter(float Foot) {
		    return (float) (Foot*304.8);
		  }
	  public static float convertFootToMile(float Foot) {
		    return (float) (Foot*0.000189394);
		  }
	  public static float convertFootToYard(float Foot) {
		    return (float) (Foot*0.333333);
		  }
	  public static float convertFootToInch(float Foot) {
		    return (float) (Foot*12);
		  }
	  public static float convertFootToNauticleMile(float Foot) {
		    return (float) (Foot*0.000164579);
		  }
	  
	  
	  
		//Length: Inch 
		  public static float convertInchToKilometer(float Inch ) {
			    return (float) (Inch *2.54*.000001);
			  }	  
		  public static float convertInchTometer(float Inch ) {
			    return (float) (Inch *0.0254);
			  }
		  public static float convertInchTocentiMeter(float Inch ) {
			    return (float) (Inch *2.54);
			  }
		  public static float convertInchToMillimeter(float Inch ) {
			    return (float) (Inch *25.4);
			  }
		  public static float convertInchToMile(float Inch ) {
			    return (float) (Inch *1.5783*.000001);
			  }
		  public static float convertInchToYard(float Inch ) {
			    return (float) (Inch *0.0277778);
			  }
		  public static float convertInchTofoot(float Inch ) {
			    return (float) (Inch *0.0833333);
			  }
		  public static float convertInchToNauticleMile(float Inch) {
			    return (float) (Inch*1.3715*.000001);
			  }
		  
	  
		  //Length: NauticleMile
		  public static float convertNauticleMileToKilometer(float NauticleMile ) {
			    return (float) (NauticleMile *1.852);
			  }	  
		  public static float convertNauticleMileTometer(float NauticleMile ) {
			    return (float) (NauticleMile *1852);
			  }
		  public static float convertNauticleMileTocentiMeter(float NauticleMile ) {
			    return (float) (NauticleMile *185200);
			  }
		  public static float convertNauticleMileToMillimeter(float NauticleMile ) {
			    return (float) (NauticleMile *1.852 *1000000);
			  }
		  public static float convertNauticleMileToMile(float NauticleMile ) {
			    return (float) (NauticleMile *1.15078);
			  }
		  public static float convertNauticleMileToYard(float NauticleMile ) {
			    return (float) (NauticleMile *2025.37);
			  }
		  public static float convertNauticleMileTofoot(float NauticleMile ) {
			    return (float) (NauticleMile *6076.12);
			  }
		  public static float convertNauticleMileToInch(float NauticleMile) {
			    return (float) (NauticleMile*72913.4);
			  }
	  

		//Storage: Bit
		  public static float convertBitToByte(float Bit) {
			    return (float) (Bit *.125);
			  }	  
		  public static float convertBitToKiloByte(float Bit) {
			    return (float) (Bit *0.00012207);
			  }
		  public static float convertBitToMegaByte(float Bit) {
			    return (float) (Bit *1.1921*.00000001);
			  }
		  public static float convertBitToGigaByte(float Bit) {
			    return (float) (Bit *1.1642e-10);
			  }
		  public static float convertBitToTeraByte(float Bit) {
			    return (float) (Bit *1.1369e-13);
			  }
		  public static float convertBitToPetaByte(float Bit) {
			    return (float) (Bit *1.1102e-16);
			  }
		  

		//Storage: BYte
		  public static float convertBYteToBit(float BYte ) {
			    return (float) (BYte *8);
			  }	  
		  public static float convertBYteToKiloByte(float BYte ) {
			    return (float) (BYte *0.000976563);
			  }
		  public static float convertBYteToMegaByte(float BYte ) {
			    return (float) (BYte *9.5367e-7);
			  }
		  public static float convertBYteToGigaByte(float BYte ) {
			    return (float) (BYte *9.3132e-10);
			  }
		  public static float convertBYteToTeraByte(float BYte ) {
			    return (float) (BYte *9.0949e-13);
			  }
		  public static float convertBYteToPetaByte(float BYte ) {
			    return (float) (BYte *8.8818e-16);
			  }
		  
		//Storage: KiloByte
		  public static float convertKiloByteToBit(float KiloByte ) {
			    return (float) (KiloByte *8192);
			  }	  
		  public static float convertKiloByteToByte(float KiloByte ) {
			    return (float) (KiloByte *1024);
			  }
		  public static float convertKiloByteToMegaByte(float KiloByte ) {
			    return (float) (KiloByte * 0.0078125);
			  }
		  public static float convertKiloByteToGigaByte(float KiloByte ) {
			    return (float) (KiloByte *9.5367e-7);
			  }
		  public static float convertKiloByteToTeraByte(float KiloByte ) {
			    return (float) (KiloByte * 9.3132e-10);
			  }
		  public static float convertKiloByteToPetaByte(float KiloByte ) {
			    return (float) (KiloByte * 9.0949e-13);
			  }
		  
		//Storage: MegaByte
		  public static float convertMegaByteToBit(float MegaByte ) {
			    return (float) (MegaByte *8.389e+6);
			  }	  
		  public static float convertMegaByteToByte(float MegaByte ) {
			    return (float) (MegaByte *1.049e+6);
			  }
		  public static float convertMegaByteToKiloByte(float MegaByte ) {
			    return (float) (MegaByte *1024);
			  }
		  public static float convertMegaByteToGigaByte(float MegaByte ) {
			    return (float) (MegaByte *0.000976563);
			  }
		  public static float convertMegaByteToTeraByte(float MegaByte ) {
			    return (float) (MegaByte *9.5367e-7);
			  }
		  public static float convertMegaByteToPetaByte(float MegaByte ) {
			    return (float) (MegaByte * 9.3132e-10);
			  }
		  

		//Storage: GigaByte
		  public static float convertGigaByteToBit(float GigaByte ) {
			    return (float) (GigaByte *8.59e+9);
			  }	  
		  public static float convertGigaByteToKiloByte(float GigaByte ) {
			    return (float) (GigaByte *1.049e+6);
			  }
		  public static float convertGigaByteToMegaByte(float GigaByte ) {
			    return (float) (GigaByte *1024);
			  }
		  public static float convertGigaByteToByte(float GigaByte ) {
			    return (float) (GigaByte *1.074e+9);
			  }
		  public static float convertGigaByteToTeraByte(float GigaByte ) {
			    return (float) (GigaByte *0.000976563);
			  }
		  public static float convertGigaByteToPetaByte(float GigaByte ) {
			    return (float) (GigaByte * 9.5367e-7);
			  }
		  
		//Storage: TeraByte
		  public static float convertTeraByteToBit(float TeraByte ) {
			    return (float) (TeraByte *8.796e+12);
			  }	  
		  public static float convertTeraByteToByte(float TeraByte ) {
			    return (float) (TeraByte *1.1e+12);
			  }
		  public static float convertTeraByteToKiloByte(float TeraByte ) {
			    return (float) (TeraByte *1.074e+9);
			  }
		  public static float convertTeraByteToMegaByte(float TeraByte ) {
			    return (float) (TeraByte * 1.049e+6);
			  }
		  public static float convertTeraByteToGigaByte(float TeraByte ) {
			    return (float) (TeraByte *1024);
			  }
		  
		  public static float convertTeraByteToPetaByte(float TeraByte ) {
			    return (float) (TeraByte *0.000976563);
			  }
		  
		//Storage: PetaByte
		  public static float convertPetaByteToBit(float PetaByte ) {
			    return (float) (PetaByte * 8.0 * 10e+15);
			  }	  
	      public static float convertPetaByteToByte(float PetaByte ) {
			    return (float) (PetaByte * 1.0 * 10e+15);
			  }  
		  public static float convertPetaByteToKiloByte(float PetaByte ) {
			    return (float) (PetaByte  * 1.0 * 10e+12);
			  }
		  public static float convertPetaByteToMegaByte(float PetaByte ) {
			    return (float) (PetaByte * 1.0 * 10e+9);
			  }
		  public static float convertPetaByteToGigaByte(float PetaByte ) {
			    return (float) (PetaByte * 1.0 * 10e+6);
			  }
		  public static float convertPetaByteToTeraByte(float PetaByte ) {
			    return (float) (PetaByte *1000);
			  }

		//Area: Square KM  
		  public static float convertSquare_KMToHectare(float Square_KM ) {
			    return (float) (Square_KM *100);
			  }  
		  public static float convertSquare_KMToSquare_Meter(float Square_KM ) {
			    return (float) (Square_KM *1e+6);
			  }
		  public static float convertSquare_KMToSquare_Mile(float Square_KM ) {
			    return (float) (Square_KM *0.386102);
			  }
		  public static float convertSquare_KMToAcre(float Square_KM ) {
			    return (float) (Square_KM *247.105);
			  }			  
		  public static float convertSquare_KMToSquare_Yard(float Square_KM ) {
			    return (float) (Square_KM *1.196e+6);
			  }	     
		  public static float convertSquare_KMToSquare_foot(float Square_KM ) {
			    return (float) (Square_KM * 1.076e+7);
			  }	  
		  
		  

		//Area: Hectare
		  public static float convertHectareToSquareKM(float Hectare ) {
			    return (float) (Hectare *0.01);
			  }  
		  public static float convertHectareToSquare_Meter(float Hectare ) {
			    return (float) (Hectare * 10000);
			  }
		  public static float convertHectareToSquare_Mile(float Hectare ) {
			    return (float) (Hectare *0.00386102);
			  }
		  public static float convertHectareToAcre(float Hectare ) {
			    return (float) (Hectare *2.47105);
			  }
		  public static float convertHectareToSquare_Yard(float Hectare ) {
			    return (float) (Hectare *11959.9);
			  }			  
		  public static float convertHectareToSquare_Foot(float Hectare ) {
			    return (float) (Hectare *107639);
			  }	     
		
		  //Area: Square Meter
		 public static float convertSquare_MeterToSquareKM(float Square_Meter ) {
				    return (float) (Square_Meter *1e-6);
				  }  
		 public static float convertSquare_MeterToHectare(float Square_Meter ) {
				    return (float) (Square_Meter * 1e-4);
				  }
		 public static float convertSquare_MeterToSquare_Mile(float Square_Meter ) {
				    return (float) (Square_Meter *3.861e-7);
				  }
		 public static float convertSquare_MeterToAcre(float Square_Meter ) {
				    return (float) (Square_Meter *0.000247105);
				  }
		 public static float convertSquare_MeterToSquare_Yard(float Square_Meter ) {
				    return (float) (Square_Meter *1.19599);
				  }			  
		 public static float convertSquare_MeterToSquare_Foot(float Square_Meter ) {
				    return (float) (Square_Meter *10.7639);
				  }	

		//Area: Square Mile
		 public static float convertSquare_MileToSquareKM(float Square_Mile ) {
			    return (float) (Square_Mile *2.58999);
			  }  
		  public static float convertSquare_MileToHectare(float Square_Mile ) {
			    return (float) (Square_Mile * 258.999);
			  }
		  public static float convertSquare_MileToSquare_Meter(float Square_Mile ) {
			    return (float) (Square_Mile *2.59e+6);
			  }
		  public static float convertSquare_MileToAcre(float Square_Mile ) {
			    return (float) (Square_Mile *640);
			  }
		  public static float convertSquare_MileToSquare_Yard(float Square_Mile ) {
			    return (float) (Square_Mile *3.098e+6);
			  }			  
		  public static float convertSquare_MileToSquare_Foot(float Square_Mile ) {
			    return (float) (Square_Mile *2.788e+7);
			  }	     

		//Area: Acre
		public static float convertAcreToSquareKM(float Acre ) {
				    return (float) (Acre *0.00404686);
				  }  
		public static float convertAcreToHectare(float Acre ) {
				    return (float) (Acre * 0.404686);
				  }
		public static float convertAcreToSquare_Meter(float Acre ) {
				    return (float) (Acre *4046.86);
				  }
		public static float convertAcreToSquare_Mile(float Acre ) {
				    return (float) (Acre *0.0015625);
				  }
		public static float convertAcreToSquare_Yard(float Acre ) {
				    return (float) (Acre *4840);
				  }			  
		public static float convertAcreToSquare_Foot(float Acre ) {
				    return (float) (Acre *43560);
				  }	  
		  
		//Area: Square Yard
		 public static float convertSquare_YardToSquareKM(float Square_Yard ) {
			    return (float) (Square_Yard *8.3613e-7);
			  }  
		  public static float convertSquare_YardToHectare(float Square_Yard ) {
			    return (float) (Square_Yard * 8.3613e-5);
			  }
		  public static float convertSquare_YardToSquare_Meter(float Square_Yard ) {
			    return (float) (Square_Yard *0.836127);
			  }
		  public static float convertSquare_YardToSquare_Mile(float Square_Yard ) {
			    return (float) (Square_Yard *3.2283e-7);
			  }
		  public static float convertSquare_YardToAcre(float Square_Yard ) {
			    return (float) (Square_Yard *0.000206612);
			  }			  
		  public static float convertSquare_YardToSquare_Foot(float Square_Yard ) {
			    return (float) (Square_Yard *9);
			  }	

		//Area: Square Foot
		public static float convertSquare_FootToSquareKM(float Square_Foot ) {
				    return (float) (Square_Foot *9.2903e-8);
				  }  
		public static float convertSquare_FootToHectare(float Square_Foot ) {
				    return (float) (Square_Foot * 9.2903e-6);
				  }
	    public static float convertSquare_FootToSquare_Meter(float Square_Foot ) {
				    return (float) (Square_Foot *0.092903);
				  }
		public static float convertSquare_FootToSquare_Mile(float Square_Foot ) {
				    return (float) (Square_Foot *3.587e-8);
				  }
		public static float convertSquare_FootToAcre(float Square_Foot ) {
				    return (float) (Square_Foot *2.2957e-5);
				  }			  
		public static float convertSquare_FootToSquare_Yard(float Square_Foot ) {
				    return (float) (Square_Foot *0.111111);
				  }	     


		//Mass: Metric Ton
		 public static float convertMetricTonToKilogram(float MetricTon ) {
			    return (float) (MetricTon *100);
			  }  
		  public static float convertMetricTonToPound(float MetricTon ) {
			    return (float) (MetricTon *1e+6);
			  }
		  public static float convertMetricTonToOunce(float MetricTon ) {
			    return (float) (MetricTon *0.386102);
			  }
		//Mass: Kilogram
		  public static float convertKilogramToMetricTon(float Kilogram ) {
			    return (float) (Kilogram *0.001);
			  }  
		  public static float convertKilogramToPound(float Kilogram ) {
			    return (float) (Kilogram *2.20462);
			  }
		  public static float convertKilogramToOunce(float Kilogram ) {
			    return (float) (Kilogram *35.274);
			  }

		//Mass: Pound
			 public static float convertPoundToMetricTon(float Pound ) {
				    return (float) (Pound *0.000453592);
				  }  
			  public static float convertPoundToKilogram(float Pound ) {
				    return (float) (Pound *0.453592);
				  }
			  public static float convertPoundToOunce(float Pound ) {
				    return (float) (Pound *16);
				  }  
		  
		  
		  
		//Mass: Ounce 
				 public static float convertOunceToMetricTon(float Ounce ) {
					    return (float) (Ounce *2.835e-5);
					  }  
				  public static float convertOunceToKilogram(float Ounce ) {
					    return (float) (Ounce *0.0283495);
					  }
				  public static float convertOunceToPound(float Ounce ) {
					    return (float) (Ounce *0.0625);
					  }


		//Speed: Meterspersec		  
	 public static float convertMeterspersecToMilesperhour(float Meterspersec ) {
					    return (float) (Meterspersec *2.23694);
					  }  
     public static float convertMeterspersecToFeetpersec(float Meterspersec ) {
					    return (float) (Meterspersec *3.28084);
					  }
	 public static float convertMeterspersecTokmperhour(float Meterspersec ) {
					    return (float) (Meterspersec *3.6);
					  }			  
				  
	//Speed: Milesperhour
	 public static float convertMilesperhourToMeterspersec(float Milesperhour ) {
		    return (float) (Milesperhour *0.44704);
		  }  
	 public static float convertMilesperhourToFeetpersec(float Milesperhour ) {
		    return (float) (Milesperhour *1.46667);
		  }
	 public static float convertMilesperhourTokmperhour(float Milesperhour ) {
		    return (float) (Milesperhour *1.60934);
		  }
	
	//Speed: Feetpersec
	 public static float convertfeetpersecToMeterspersec(float feetpersec ) {
		    return (float) (feetpersec *0.3048);
		  }  
	 public static float convertfeetpersecToMilesperhour(float feetpersec ) {
		    return (float) (feetpersec *0.681818);
		  }
	 public static float convertfeetpersecTokmperhour(float feetpersec ) {
		    return (float) (feetpersec *1.09728);
		  }
	 
	 
	//Speed: kmperhour 
	 public static float convertkmperhourToMeterspersec(float kmperhour ) {
		    return (float) (kmperhour *0.277778);
		  }  
	 public static float convertkmperhourToMilesperhour(float kmperhour ) {
		    return (float) (kmperhour *0.621371);
		  }
	 public static float convertkmperhourTofeetpersec(float kmperhour ) {
		    return (float) (kmperhour *0.911344);
		  }

	//Grocery: unit conversion 
		 public static float convertkgToKg(float kg1,float kg2,float price) {
			    return (float) ((kg2*price)/kg1);
			  }  
		 public static float convertgmTogm(float gm1,float gm2,float price ) {
			    return (float) ((gm2*price)/gm1);
			  }
		 public static float convertgmTokg(float gm,float kg,float price ) {
			    return (float) ((kg*1000*price)/gm);
			  }
		 public static float convertkgTogm(float kg,float gm,float price  ) {
			    return (float) ((gm*price)/(kg*1000));
			  }
	 
}