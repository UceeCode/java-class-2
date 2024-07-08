package Enum;

public enum Zodaic_Signs {
    One("Aries (March 21 - April 19)", "Assertive, energetic, courageous, passionate."),
    Two("Taurus (April 20 - May 20)", "Practical, reliable, patient, determined."),
    Three("Gemini (May 21 - June 20)", "Versatile, adaptable, sociable, curious"),
    Four("Cancer (June 21 - July 22)", "Nurturing, empathetic, intuitive"),
    Five("Leo (July 23 - August 22)", "Confident, generous, warm-hearted"),
    Six("Virgo (August 23 - September 22)", "Practical, analytical, detail-oriented"),
    Seven("Libra (September 23 - October 22)", "Diplomatic, cooperative, fair-minded"),
    Eight("Scorpio (October 23 - November 21)", "Intense, passionate, resourceful"),
    Nine("Sagittarius (November 22 - December 21)", "Optimistic, adventurous, philosophical"),
    Ten("Capricorn (December 22 - January 19)", "Responsible, disciplined, ambitious,"),
    Eleven("Aquarius (January 20 - February 18)", "Innovative, progressive, humanitarian"),
    Twelve("Pisces (February 19 - March 20)", "Compassionate, artistic, intuitive, gentle");
    private final String signs;
    private final String meaning;
    Zodaic_Signs(String signs, String meaning){
        this.signs = signs;
        this.meaning = meaning;
    }

    public String getSigns(){
        return signs;
    }

    public String getMeaning(){
        return meaning;
    }

    public static void main(String[] args) {
        for(Zodaic_Signs printSigns : Zodaic_Signs.values()){
            System.out.printf("%-25s%-50s%s\n", printSigns, printSigns.getSigns(), printSigns.getMeaning());
        }
    }
}
