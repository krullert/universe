package io.onsense.universe;

import org.apache.commons.validator.routines.*;
import org.apache.commons.validator.routines.checkdigit.*;
import org.hibernate.validator.constraints.Mod11Check;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.internal.constraintvalidators.hv.Mod10CheckValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.Mod11CheckValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.SafeHtmlValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.pl.NIPValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.pl.PESELValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.pl.REGONValidator;

import javax.annotation.Nonnull;
import java.util.regex.Pattern;

/**
 * @author Koen Rooijmans
 */
public class Code {

    public final static Pattern URN_PATTERN = Pattern.compile("^urn:[a-z0-9][a-z0-9-]{0,31}:([a-z0-9()+,\\-.:=@;$_!*']|%[0-9a-f]{2})+$", Pattern.CASE_INSENSITIVE);

    protected static final IBANValidator.Validator[] DEFAULT_FORMATS = {
//            new IBANValidator.Validator("AF",20,""), // AFGHANISTAN
            new IBANValidator.Validator("AX", 18, "AX\\d{16}"), // ALAND_ISLANDS
            new IBANValidator.Validator("AL", 28, "AL\\d{10}[A-Z0-9]{16}"), // Albania
//            new IBANValidator.Validator("DZ",20,""), // ALGERIA
//            new IBANValidator.Validator("AS",20,""), // AMERICAN_SAMOA
            new IBANValidator.Validator("AD", 24, "AD\\d{10}[A-Z0-9]{12}"), // Andorra
//            new IBANValidator.Validator("AO",20,""), // ANGOLA
//            new IBANValidator.Validator("AI",20,""), // ANGUILLA
//            new IBANValidator.Validator("AQ",20,""), // ANTARCTICA
//            new IBANValidator.Validator("AG",20,""), // ANTIGUA_AND_BARBUDA
//            new IBANValidator.Validator("AR",20,""), // ARGENTINA
//            new IBANValidator.Validator("AM",20,""), // ARMENIA
//            new IBANValidator.Validator("AW",20,""), // ARUBA
//            new IBANValidator.Validator("AU",20,""), // AUSTRALIA
            new IBANValidator.Validator("AT", 20, "AT\\d{18}"), // Austria
            new IBANValidator.Validator("AZ", 28, "AZ\\d{2}[A-Z]{4}[A-Z0-9]{20}"), // Republic of Azerbaijan
//            new IBANValidator.Validator("BS",20,""), // BAHAMAS
            new IBANValidator.Validator("BH", 22, "BH\\d{2}[A-Z]{4}[A-Z0-9]{14}"), // Bahrain (Kingdom of)
//            new IBANValidator.Validator("BD",20,""), // BANGLADESH
//            new IBANValidator.Validator("BB",20,""), // BARBADOS
            new IBANValidator.Validator("BY", 28, "BY\\d{2}[A-Z0-9]{4}\\d{4}[A-Z0-9]{16}"), // Republic of Belarus
            new IBANValidator.Validator("BE", 16, "BE\\d{14}"), // Belgium
//            new IBANValidator.Validator("BZ",20,""), // BELIZE
//            new IBANValidator.Validator("BJ",20,""), // BENIN
//            new IBANValidator.Validator("BM",20,""), // BERMUDA
//            new IBANValidator.Validator("BT",20,""), // BHUTAN
//            new IBANValidator.Validator("BO",20,""), // BOLIVIA
//            new IBANValidator.Validator("BQ",20,""), // BONAIRE
            new IBANValidator.Validator("BA", 20, "BA\\d{18}"), // Bosnia and Herzegovina
//            new IBANValidator.Validator("BW",20,""), // BOTSWANA
//            new IBANValidator.Validator("BV",20,""), // BOUVET_ISLAND
            new IBANValidator.Validator("BR", 29, "BR\\d{25}[A-Z]{1}[A-Z0-9]{1}"), // Brazil
//            new IBANValidator.Validator("IO",20,""), // BRITISH_INDIAN_OCEAN_TERRITORY
            new IBANValidator.Validator("VG", 24, "VG\\d{2}[A-Z]{4}\\d{16}"), // Virgin Islands, British
//            new IBANValidator.Validator("BN",20,""), // BRUNEI_DARUSSALAM
            new IBANValidator.Validator("BG", 22, "BG\\d{2}[A-Z]{4}\\d{6}[A-Z0-9]{8}"), // Bulgaria
//            new IBANValidator.Validator("BF",20,""), // BURKINA_FASO
//            new IBANValidator.Validator("BI",20,""), // BURUNDI
//            new IBANValidator.Validator("KH",20,""), // CAMBODIA
//            new IBANValidator.Validator("CM",20,""), // CAMEROON
//            new IBANValidator.Validator("CA",20,""), // CANADA
//            new IBANValidator.Validator("CV",20,""), // CAPE_VERDE
//            new IBANValidator.Validator("KY",20,""), // CAYMAN_ISLANDS
//            new IBANValidator.Validator("CF",20,""), // CENTRAL_AFRICAN_REPUBLIC
//            new IBANValidator.Validator("TD",20,""), // CHAD
//            new IBANValidator.Validator("CL",20,""), // CHILE
//            new IBANValidator.Validator("CN",20,""), // CHINA
//            new IBANValidator.Validator("CX",20,""), // CHRISTMAS_ISLAND
//            new IBANValidator.Validator("CC",20,""), // COCOS_ISLANDS
//            new IBANValidator.Validator("CO",20,""), // COLOMBIA
//            new IBANValidator.Validator("KM",20,""), // COMOROS
//            new IBANValidator.Validator("CG",20,""), // CONGO
//            new IBANValidator.Validator("CK",20,""), // COOK_ISLANDS
            new IBANValidator.Validator("CR", 22, "CR\\d{20}"), // Costa Rica
//            new IBANValidator.Validator("CI",20,""), // COTE_D_IVOIRE
            new IBANValidator.Validator("HR", 21, "HR\\d{19}"), // Croatia
//            new IBANValidator.Validator("CU",20,""), // CUBA
//            new IBANValidator.Validator("CW",20,""), // CURACAO
            new IBANValidator.Validator("CY", 28, "CY\\d{10}[A-Z0-9]{16}"), // Cyprus
            new IBANValidator.Validator("CZ", 24, "CZ\\d{22}"), // Czech Republic
            new IBANValidator.Validator("DK", 18, "DK\\d{16}"), // Denmark
//            new IBANValidator.Validator("DJ",20,""), // DJIBOUTI
//            new IBANValidator.Validator("DM",20,""), // DOMINICA
            new IBANValidator.Validator("DO", 28, "DO\\d{2}[A-Z0-9]{4}\\d{20}"), // Dominican Republic
//            new IBANValidator.Validator("EC",20,""), // ECUADOR
//            new IBANValidator.Validator("EG",20,""), // EGYPT
            new IBANValidator.Validator("SV", 28, "SV\\d{2}[A-Z0-9]{4}\\d{20}"), // EL_SALVADOR
//            new IBANValidator.Validator("GQ",20,""), // EQUATORIAL_GUINEA
//            new IBANValidator.Validator("ER",20,""), // ERITREA
            new IBANValidator.Validator("EE", 20, "EE\\d{18}"), // Estonia
//            new IBANValidator.Validator("ET",20,""), // ETHIOPIA
//            new IBANValidator.Validator("FK",20,""), // FALKLAND_ISLANDS
            new IBANValidator.Validator("FO", 18, "FO\\d{16}"), // Denmark (Faroes)
//            new IBANValidator.Validator("FJ",20,""), // FIJI
            new IBANValidator.Validator("FI", 18, "FI\\d{16}"), // Finland
            new IBANValidator.Validator("FR", 27, "FR\\d{12}[A-Z0-9]{11}\\d{2}"), // France
            new IBANValidator.Validator("GF", 27, "GF\\d{12}[A-Z0-9]{11}\\d{2}"), // FRENCH_GUIANA
            new IBANValidator.Validator("PF", 27, "PF\\d{12}[A-Z0-9]{11}\\d{2}"), // FRENCH_POLYNESIA
            new IBANValidator.Validator("TF", 27, "TF\\d{12}[A-Z0-9]{11}\\d{2}"), // FRENCH_SOUTHERN_TERRITORIES
//            new IBANValidator.Validator("GA",20,""), // GABON
//            new IBANValidator.Validator("GM",20,""), // GAMBIA
            new IBANValidator.Validator("GE", 22, "GE\\d{2}[A-Z]{2}\\d{16}"), // Georgia
            new IBANValidator.Validator("DE", 22, "DE\\d{20}"), // Germany
//            new IBANValidator.Validator("GH",20,""), // GHANA
            new IBANValidator.Validator("GI", 23, "GI\\d{2}[A-Z]{4}[A-Z0-9]{15}"), // Gibraltar
            new IBANValidator.Validator("GR", 27, "GR\\d{9}[A-Z0-9]{16}"), // Greece
            new IBANValidator.Validator("GL", 18, "GL\\d{16}"), // Denmark (Greenland)
//            new IBANValidator.Validator("GD",20,""), // GRENADA
            new IBANValidator.Validator("GP", 27, "GP\\d{12}[A-Z0-9]{11}\\d{2}"), // GUADELOUPE
//            new IBANValidator.Validator("GU",20,""), // GUAM
            new IBANValidator.Validator("GT", 28, "GT\\d{2}[A-Z0-9]{24}"), // Guatemala
            new IBANValidator.Validator("GG", 22, "GG\\d{2}[A-Z]{4}\\d{14}"), // GUERNSEY
//            new IBANValidator.Validator("GN",20,""), // GUINEA
//            new IBANValidator.Validator("GW",20,""), // GUINEA_BISSAU
//            new IBANValidator.Validator("GY",20,""), // GUYANA
//            new IBANValidator.Validator("HT",20,""), // HAITI
//            new IBANValidator.Validator("HM",20,""), // HEARD_ISLAND_AND_MCDONALD_ISLANDS
//            new IBANValidator.Validator("HN",20,""), // HONDURAS
//            new IBANValidator.Validator("HK",20,""), // HONG_KONG
            new IBANValidator.Validator("HU", 28, "HU\\d{26}"), // Hungary
            new IBANValidator.Validator("IS", 26, "IS\\d{24}"), // Iceland
//            new IBANValidator.Validator("IN",20,""), // INDIA
//            new IBANValidator.Validator("ID",20,""), // INDONESIA
//            new IBANValidator.Validator("IR",20,""), // IRAN
            new IBANValidator.Validator("IQ", 23, "IQ\\d{2}[A-Z]{4}\\d{15}"), // Iraq
            new IBANValidator.Validator("IE", 22, "IE\\d{2}[A-Z]{4}\\d{14}"), // Ireland
            new IBANValidator.Validator("IM", 22, "IM\\d{2}[A-Z]{4}\\d{14}"), // ISLE_OF_MAN
            new IBANValidator.Validator("IL", 23, "IL\\d{21}"), // Israel
            new IBANValidator.Validator("IT", 27, "IT\\d{2}[A-Z]{1}\\d{10}[A-Z0-9]{12}"), // Italy
//            new IBANValidator.Validator("JM",20,""), // JAMAICA
//            new IBANValidator.Validator("JP",20,""), // JAPAN
            new IBANValidator.Validator("JE", 22, "JE\\d{2}[A-Z]{4}\\d{14}"), // JERSEY
            new IBANValidator.Validator("JO", 30, "JO\\d{2}[A-Z]{4}\\d{4}[A-Z0-9]{18}"), // Jordan
            new IBANValidator.Validator("KZ", 20, "KZ\\d{5}[A-Z0-9]{13}"), // Kazakhstan
//            new IBANValidator.Validator("KE",20,""), // KENYA
//            new IBANValidator.Validator("KI",20,""), // KIRIBATI
            new IBANValidator.Validator("XK", 20, "XK\\d{18}"), // Republic of Kosovo
            new IBANValidator.Validator("KW", 30, "KW\\d{2}[A-Z]{4}[A-Z0-9]{22}"), // Kuwait
//            new IBANValidator.Validator("KG",20,""), // KYRGYZSTAN
//            new IBANValidator.Validator("LA",20,""), // LAO_PEOPLES_DEMOCRATIC_REPUBLIC
            new IBANValidator.Validator("LV", 21, "LV\\d{2}[A-Z]{4}[A-Z0-9]{13}"), // Latvia
            new IBANValidator.Validator("LB", 28, "LB\\d{6}[A-Z0-9]{20}"), // Lebanon
//            new IBANValidator.Validator("LS",20,""), // LESOTHO
//            new IBANValidator.Validator("LR",20,""), // LIBERIA
//            new IBANValidator.Validator("LY",20,""), // LIBYA
            new IBANValidator.Validator("LI", 21, "LI\\d{7}[A-Z0-9]{12}"), // Liechtenstein (Principality of)
            new IBANValidator.Validator("LT", 20, "LT\\d{18}"), // Lithuania
            new IBANValidator.Validator("LU", 20, "LU\\d{5}[A-Z0-9]{13}"), // Luxembourg
//            new IBANValidator.Validator("MO",20,""), // MACAO
            new IBANValidator.Validator("MK", 19, "MK\\d{5}[A-Z0-9]{10}\\d{2}"), // Macedonia, Former Yugoslav Republic of
//            new IBANValidator.Validator("MG",20,""), // MADAGASCAR
//            new IBANValidator.Validator("MW",20,""), // MALAWI
//            new IBANValidator.Validator("MY",20,""), // MALAYSIA
//            new IBANValidator.Validator("MV",20,""), // MALDIVES
//            new IBANValidator.Validator("ML",20,""), // MALI
            new IBANValidator.Validator("MT", 31, "MT\\d{2}[A-Z]{4}\\d{5}[A-Z0-9]{18}"), // Malta
//            new IBANValidator.Validator("MH",20,""), // MARSHALL_ISLANDS
            new IBANValidator.Validator("MQ", 27, "MQ\\d{12}[A-Z0-9]{11}\\d{2}"), // MARTINIQUE
            new IBANValidator.Validator("MR", 27, "MR\\d{25}"), // Mauritania
            new IBANValidator.Validator("MU", 30, "MU\\d{2}[A-Z]{4}\\d{19}[A-Z]{3}"), // Mauritius
            new IBANValidator.Validator("YT", 27, "YT\\d{12}[A-Z0-9]{11}\\d{2}"), // MAYOTTE
//            new IBANValidator.Validator("MX",20,""), // MEXICO
//            new IBANValidator.Validator("FM",20,""), // MICRONESIA
            new IBANValidator.Validator("MD", 24, "MD\\d{2}[A-Z0-9]{20}"), // Moldova
            new IBANValidator.Validator("MC", 27, "MC\\d{12}[A-Z0-9]{11}\\d{2}"), // Monaco
//            new IBANValidator.Validator("MN",20,""), // MONGOLIA
            new IBANValidator.Validator("ME", 22, "ME\\d{20}"), // Montenegro
//            new IBANValidator.Validator("MS",20,""), // MONTSERRAT
//            new IBANValidator.Validator("MA",20,""), // MOROCCO
//            new IBANValidator.Validator("MZ",20,""), // MOZAMBIQUE
//            new IBANValidator.Validator("MM",20,""), // MYANMAR
//            new IBANValidator.Validator("NA",20,""), // NAMIBIA
//            new IBANValidator.Validator("NR",20,""), // NAURU
//            new IBANValidator.Validator("NP",20,""), // NEPAL
            new IBANValidator.Validator("NL", 18, "NL\\d{2}[A-Z]{4}\\d{10}"), // The Netherlands
            new IBANValidator.Validator("NC", 27, "NC\\d{12}[A-Z0-9]{11}\\d{2}"), // NEW_CALEDONIA
//            new IBANValidator.Validator("NZ",20,""), // NEW_ZEALAND
//            new IBANValidator.Validator("NI",20,""), // NICARAGUA
//            new IBANValidator.Validator("NE",20,""), // NIGER
//            new IBANValidator.Validator("NG",20,""), // NIGERIA
//            new IBANValidator.Validator("NU",20,""), // NIUE
//            new IBANValidator.Validator("NF",20,""), // NORFOLK_ISLAND
//            new IBANValidator.Validator("MP",20,""), // NORTHERN_MARIANA_ISLANDS
//            new IBANValidator.Validator("KP",20,""), // NORTH_KOREA
            new IBANValidator.Validator("NO", 15, "NO\\d{13}"), // Norway
//            new IBANValidator.Validator("OM",20,""), // OMAN
            new IBANValidator.Validator("PK", 24, "PK\\d{2}[A-Z]{4}[A-Z0-9]{16}"), // Pakistan
//            new IBANValidator.Validator("PW",20,""), // PALAU
            new IBANValidator.Validator("PS", 29, "PS\\d{2}[A-Z]{4}[A-Z0-9]{21}"), // Palestine, State of
//            new IBANValidator.Validator("PA",20,""), // PANAMA
//            new IBANValidator.Validator("PG",20,""), // PAPUA_NEW_GUINEA
//            new IBANValidator.Validator("PY",20,""), // PARAGUAY
//            new IBANValidator.Validator("PE",20,""), // PERU
//            new IBANValidator.Validator("PH",20,""), // PHILIPPINES
//            new IBANValidator.Validator("PN",20,""), // PITCAIRN
            new IBANValidator.Validator("PL", 28, "PL\\d{26}"), // Poland
            new IBANValidator.Validator("PT", 25, "PT\\d{23}"), // Portugal
//            new IBANValidator.Validator("PR",20,""), // PUERTO_RICO
            new IBANValidator.Validator("QA", 29, "QA\\d{2}[A-Z]{4}[A-Z0-9]{21}"), // Qatar
            new IBANValidator.Validator("RE", 27, "RE\\d{12}[A-Z0-9]{11}\\d{2}"), // REUNION
            new IBANValidator.Validator("RO", 24, "RO\\d{2}[A-Z]{4}[A-Z0-9]{16}"), // Romania
//            new IBANValidator.Validator("RU",20,""), // RUSSIAN_FEDERATION
//            new IBANValidator.Validator("RW",20,""), // RWANDA
            new IBANValidator.Validator("BL", 27, "BL\\d{12}[A-Z0-9]{11}\\d{2}"), // SAINT_BARTHELEMY
//            new IBANValidator.Validator("SH",20,""), // SAINT_HELENA
//            new IBANValidator.Validator("KN",20,""), // SAINT_KITTS_AND_NEVIS
            new IBANValidator.Validator("LC", 32, "LC\\d{2}[A-Z]{4}[A-Z0-9]{24}"), // Saint Lucia
            new IBANValidator.Validator("MF", 27, "MF\\d{12}[A-Z0-9]{11}\\d{2}"), // SAINT_MARTIN
            new IBANValidator.Validator("PM", 27, "PM\\d{12}[A-Z0-9]{11}\\d{2}"), // SAINT_PIERRE_AND_MIQUELON
//            new IBANValidator.Validator("VC",20,""), // SAINT_VINCENT_AND_THE_GRENADINES
//            new IBANValidator.Validator("WS",20,""), // SAMOA
            new IBANValidator.Validator("SM", 27, "SM\\d{2}[A-Z]{1}\\d{10}[A-Z0-9]{12}"), // San Marino
            new IBANValidator.Validator("ST", 25, "ST\\d{23}"), // Sao Tome and Principe
            new IBANValidator.Validator("SA", 24, "SA\\d{4}[A-Z0-9]{18}"), // Saudi Arabia
//            new IBANValidator.Validator("SN",20,""), // SENEGAL
            new IBANValidator.Validator("RS", 22, "RS\\d{20}"), // Serbia
            new IBANValidator.Validator("SC", 31, "SC\\d{2}[A-Z]{4}\\d{20}[A-Z]{3}"), // Seychelles
//            new IBANValidator.Validator("SL",20,""), // SIERRA_LEONE
//            new IBANValidator.Validator("SG",20,""), // SINGAPORE
//            new IBANValidator.Validator("SX",20,""), // SINT_MAARTEN
            new IBANValidator.Validator("SK", 24, "SK\\d{22}"), // Slovak Republic
            new IBANValidator.Validator("SI", 19, "SI\\d{17}"), // Slovenia
//            new IBANValidator.Validator("SB",20,""), // SOLOMON_ISLANDS
//            new IBANValidator.Validator("SO",20,""), // SOMALIA
//            new IBANValidator.Validator("ZA",20,""), // SOUTH_AFRICA
//            new IBANValidator.Validator("GS",20,""), // SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS
//            new IBANValidator.Validator("KR",20,""), // SOUTH_KOREA
//            new IBANValidator.Validator("SS",20,""), // SOUTH_SUDAN
            new IBANValidator.Validator("ES", 24, "ES\\d{22}"), // Spain
//            new IBANValidator.Validator("LK",20,""), // SRI_LANKA
//            new IBANValidator.Validator("SD",20,""), // SUDAN
//            new IBANValidator.Validator("SR",20,""), // SURINAME
//            new IBANValidator.Validator("SJ",20,""), // SVALBARD_AND_JAN_MAYEN
//            new IBANValidator.Validator("SZ",20,""), // SWAZILAND
            new IBANValidator.Validator("SE", 24, "SE\\d{22}"), // Sweden
            new IBANValidator.Validator("CH", 21, "CH\\d{7}[A-Z0-9]{12}"), // Switzerland
//            new IBANValidator.Validator("SY",20,""), // SYRIAN_ARAB_REPUBLIC
//            new IBANValidator.Validator("TW",20,""), // TAIWAN
//            new IBANValidator.Validator("TJ",20,""), // TAJIKISTAN
//            new IBANValidator.Validator("TZ",20,""), // TANZANIA
//            new IBANValidator.Validator("TH",20,""), // THAILAND
//            new IBANValidator.Validator("CD",20,""), // THE_DEMOCRATIC_REPUBLIC_OF_THE_CONGO
            new IBANValidator.Validator("TL", 23, "TL\\d{21}"), // Timor-Leste
//            new IBANValidator.Validator("TG",20,""), // TOGO
//            new IBANValidator.Validator("TK",20,""), // TOKELAU
//            new IBANValidator.Validator("TO",20,""), // TONGA
//            new IBANValidator.Validator("TT",20,""), // TRINIDAD_AND_TOBAGO
            new IBANValidator.Validator("TN", 24, "TN\\d{22}"), // Tunisia
            new IBANValidator.Validator("TR", 26, "TR\\d{8}[A-Z0-9]{16}"), // Turkey
//            new IBANValidator.Validator("TM",20,""), // TURKMENISTAN
//            new IBANValidator.Validator("TC",20,""), // TURKS_AND_CAICOS_ISLANDS
//            new IBANValidator.Validator("TV",20,""), // TUVALU
//            new IBANValidator.Validator("UG",20,""), // UGANDA
            new IBANValidator.Validator("UA", 29, "UA\\d{8}[A-Z0-9]{19}"), // Ukraine
            new IBANValidator.Validator("AE", 23, "AE\\d{21}"), // United Arab Emirates
            new IBANValidator.Validator("GB", 22, "GB\\d{2}[A-Z]{4}\\d{14}"), // United Kingdom
//            new IBANValidator.Validator("US",20,""), // UNITED_STATES
//            new IBANValidator.Validator("UM",20,""), // UNITED_STATES_MINOR_OUTLYING_ISLANDS
//            new IBANValidator.Validator("UY",20,""), // URUGUAY
//            new IBANValidator.Validator("VI",20,""), // US_VIRGIN_ISLANDS
//            new IBANValidator.Validator("UZ",20,""), // UZBEKISTAN
//            new IBANValidator.Validator("VU",20,""), // VANUATU
//            new IBANValidator.Validator("VA",20,""), // VATICAN_CITY_STATE
//            new IBANValidator.Validator("VE",20,""), // VENEZUELA
//            new IBANValidator.Validator("VN",20,""), // VIET_NAM
            new IBANValidator.Validator("WF", 27, "WF\\d{12}[A-Z0-9]{11}\\d{2}"), // WALLIS_AND_FUTUNA
//            new IBANValidator.Validator("EH",20,""), // WESTERN_SAHARA
//            new IBANValidator.Validator("YE",20,""), // YEMEN
//            new IBANValidator.Validator("ZM",20,""), // ZAMBIA
//            new IBANValidator.Validator("ZW",20,""), // ZIMBABWE
    };
    protected static IBANValidator IBAN_VALIDATOR;
    protected static SafeHtmlValidator SAFE_HTML_VALIDATOR;
    protected static SafeHtmlValidator STRICT_SAFE_HTML_VALIDATOR;

    protected static IBANValidator getIBANValidatorInstance() {
        if (IBAN_VALIDATOR == null) {
            IBAN_VALIDATOR = new IBANValidator(Code.DEFAULT_FORMATS);
        }
        return IBAN_VALIDATOR;
    }


    @Nonnull
    protected static SafeHtmlValidator getSafeHtmlValidator(boolean strict) {
        if (strict) {
            if (STRICT_SAFE_HTML_VALIDATOR == null) {
                STRICT_SAFE_HTML_VALIDATOR = new SafeHtmlValidator();
                STRICT_SAFE_HTML_VALIDATOR.initialize(StrictSafeHtml.class.getAnnotation(SafeHtml.class));
            }

            return STRICT_SAFE_HTML_VALIDATOR;
        } else {
            if (SAFE_HTML_VALIDATOR == null) {
                SAFE_HTML_VALIDATOR = new SafeHtmlValidator();
                SAFE_HTML_VALIDATOR.initialize(NonStrictSafeHtml.class.getAnnotation(SafeHtml.class));
            }
            return SAFE_HTML_VALIDATOR;
        }
    }

    public static Logical code_isiban(CharSequence value) {
        return code_isiban(value, false);
    }

    public static Logical code_isiban(CharSequence value, boolean strict) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        if (strict) {
            return Logical.valueOf(getIBANValidatorInstance()
                    .isValid(String.valueOf(value).replaceAll(" ", "")));
        } else {
            return Logical.valueOf(IBANCheckDigit.IBAN_CHECK_DIGIT.isValid(String.valueOf(value).replaceAll(" ", "")));
        }
    }

    public static Logical code_isisin(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        if (value.length() != 12 // ISIN
                && value.length() != 7 // SEDOL
                && value.length() != 6 // WKN
                && value.length() != 9) { // CUSIP
            return Logical.FALSE;
        }
        return Logical.valueOf(ISINCheckDigit.ISIN_CHECK_DIGIT.isValid(String.valueOf(value)));
    }

    public static Logical code_isissn(CharSequence value) {
        return code_isissn(value, false);
    }

    public static Logical code_isissn(CharSequence value, boolean normalize) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        final String normalizedValue;
        if (value.length() == 8 && normalize && value.chars().allMatch(Character::isDigit)) {
            normalizedValue = String.valueOf(value.subSequence(0, 4)) + "-" + String.valueOf(value.subSequence(4, 8));
        } else {
            normalizedValue = String.valueOf(value);
        }
        return Logical.valueOf(ISSNValidator.getInstance()
                .isValid(String.valueOf(normalizedValue)));
    }

    public static Logical code_isisbn(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(ISBNValidator.getInstance()
                .isValid(String.valueOf(value))
                || code_isisbn10(value).booleanValue()
                || code_isisbn13(value).booleanValue());
    }

    public static Logical code_isisbn10(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(ISBNValidator.getInstance(false)
                .isValidISBN10(String.valueOf(value)));
    }

    public static Logical code_isisbn13(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(ISBNValidator.getInstance(false)
                .isValidISBN13(String.valueOf(value)));
    }

    public static Logical code_isean(CharSequence value) {
        return Logical.valueOf(code_isean8(value).booleanValue() || code_isean13(value).booleanValue());
    }

    public static Logical code_isean8(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        if (value.length() != 8) {
            return Logical.FALSE;
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            return Logical.FALSE;
        }

        return Logical.valueOf(EAN13CheckDigit.EAN13_CHECK_DIGIT.isValid(String.valueOf(value)));
    }

    public static Logical code_isean13(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        if (value.length() != 13) {
            return Logical.FALSE;
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            return Logical.FALSE;
        }
        return Logical.valueOf(EAN13CheckDigit.EAN13_CHECK_DIGIT.isValid(String.valueOf(value)));
    }

    public static Logical code_isupca(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        if (value.length() != 12) {
            return Logical.FALSE;
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            return Logical.FALSE;
        }
        return Logical.valueOf(EAN13CheckDigit.EAN13_CHECK_DIGIT.isValid(String.valueOf(value)));
    }

    public static Logical code_isupce(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        if (value.length() != 8) {
            return Logical.FALSE;
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            return Logical.FALSE;
        }
        return Logical.valueOf(EAN13CheckDigit.EAN13_CHECK_DIGIT.isValid(String.valueOf(value)));
    }

    public static ExpressionString code_iban(CharSequence value) {
        if (value == null) {
            return null;
        }

        throw new UnsupportedOperationException();
    }

    public static ExpressionString code_isin(CharSequence value) {
        if (value == null) {
            return null;
        }

        if (!code_isisin(value).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_isin_cd(value));
            if (!code_isisin(valueWithCheckDigit).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            return valueWithCheckDigit;
        } else {
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_issn(CharSequence value) {
        return code_issn(value, true);
    }

    public static ExpressionString code_issn(CharSequence value, boolean normalize) {
        if (value == null) {
            return null;
        }

        if (!code_isissn(value, true).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_issn_cd(value));
            if (!code_isissn(valueWithCheckDigit, true).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            if (normalize && valueWithCheckDigit.length() == 8) {
                return ExpressionString.valueOf(String.valueOf(valueWithCheckDigit.subSequence(0, 4)) + "-" + String.valueOf(valueWithCheckDigit.subSequence(4, 8)));
            }
            return valueWithCheckDigit;
        } else {
            if (normalize && value.length() == 8) {
                return ExpressionString.valueOf(String.valueOf(value.subSequence(0, 4)) + "-" + String.valueOf(value.subSequence(4, 8)));
            }
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_isbn(CharSequence value) {
        if (value == null) {
            return null;
        }

        if (!code_isisbn(value).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_isbn_cd(value));
            if (!code_isisbn(valueWithCheckDigit).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            return valueWithCheckDigit;
        } else {
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_isbn10(CharSequence value) {
        if (value == null) {
            return null;
        }

        if (!code_isisbn10(value).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_isbn10_cd(value));
            if (!code_isisbn10(valueWithCheckDigit).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            return valueWithCheckDigit;
        } else {
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_isbn13(CharSequence value) {
        if (value == null) {
            return null;
        }

        if (!code_isisbn13(value).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_isbn13_cd(value));
            if (!code_isisbn13(valueWithCheckDigit).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            return valueWithCheckDigit;
        } else {
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_ean(CharSequence value) {
        if (value == null) {
            return null;
        }

        if (!code_isean(value).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_ean_cd(value));
            if (!code_isean(valueWithCheckDigit).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            return valueWithCheckDigit;
        } else {
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_ean8(CharSequence value) {
        if (value == null) {
            return null;
        }

        if (!code_isean8(value).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_ean8_cd(value));
            if (!code_isean8(valueWithCheckDigit).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            return valueWithCheckDigit;
        } else {
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_ean13(CharSequence value) {
        if (value == null) {
            return null;
        }

        if (!code_isean13(value).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_ean13_cd(value));
            if (!code_isean13(valueWithCheckDigit).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            return valueWithCheckDigit;
        } else {
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_upca(CharSequence value) {
        if (value == null) {
            return null;
        }

        if (!code_isupca(value).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_upca_cd(value));
            if (!code_isupca(valueWithCheckDigit).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            return valueWithCheckDigit;
        } else {
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_upce(CharSequence value) {
        if (value == null) {
            return null;
        }

        if (!code_isupce(value).booleanValue()) {
            final ExpressionString valueWithCheckDigit = ExpressionString.valueOf(value).add(code_upce_cd(value));
            if (!code_isupce(valueWithCheckDigit).booleanValue()) {
                throw new UniversalException(valueWithCheckDigit, "value", 0, UniversalException.ErrorType.VALUE);
            }
            return valueWithCheckDigit;
        } else {
            return ExpressionString.valueOf(value);
        }
    }

    public static ExpressionString code_iban_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        try {
            return ExpressionString.valueOf(IBANCheckDigit.IBAN_CHECK_DIGIT.calculate(String.valueOf(value).replaceAll(" ", "")));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
    }

    public static ExpressionString code_isin_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        try {
            return ExpressionString.valueOf(ISINCheckDigit.ISIN_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
    }

    public static ExpressionString code_issn_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        try {
            return ExpressionString.valueOf(ISSNCheckDigit.ISSN_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
    }

    public static ExpressionString code_isbn_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        try {
            return ExpressionString.valueOf(ISBNCheckDigit.ISBN_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
    }

    public static ExpressionString code_isbn10_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        if (value.length() != 9) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return ExpressionString.valueOf(ISBNCheckDigit.ISBN10_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString code_isbn13_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        if (value.length() != 12) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return ExpressionString.valueOf(ISBNCheckDigit.ISBN13_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString code_ean_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        if (value.length() != 7 && value.length() != 12) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return ExpressionString.valueOf(EAN13CheckDigit.EAN13_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString code_ean8_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        if (value.length() != 7) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return ExpressionString.valueOf(EAN13CheckDigit.EAN13_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString code_ean13_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        if (value.length() != 12) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return ExpressionString.valueOf(EAN13CheckDigit.EAN13_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString code_upca_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        try {
            return ExpressionString.valueOf(EAN13CheckDigit.EAN13_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString code_upce_cd(CharSequence value) {
        if (value == null) {
            return null;
        }
        try {
            return ExpressionString.valueOf(EAN13CheckDigit.EAN13_CHECK_DIGIT.calculate(String.valueOf(value)));
        } catch (CheckDigitException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static Logical code_issafehtml(CharSequence value) {
        return code_issafehtml(value, true);
    }

    public static Logical code_issafehtml(CharSequence value, boolean strict) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(getSafeHtmlValidator(strict).isValid(value, null));
    }

    public static Logical code_isemail(CharSequence value) {
        return code_isemail(value, false);
    }

    public static Logical code_isemail(CharSequence value, boolean strict) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        if (strict) {
            return Logical.valueOf(EmailValidator.getInstance().isValid(String.valueOf(value)));
        } else {
            return Logical.valueOf(EmailValidator.getInstance(true, true).isValid(String.valueOf(value)));
        }
    }

    public static Logical code_isregex(CharSequence value, CharSequence regex) {
        return code_isregex(value, regex, true);
    }

    public static Logical code_isregex(CharSequence value, CharSequence regex, boolean caseSensitive) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        if (regex == null || regex.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(new RegexValidator(String.valueOf(regex), caseSensitive).isValid(String.valueOf(value)));
    }

    public static Logical code_isip(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(InetAddressValidator.getInstance().isValid(String.valueOf(value)));
    }

    public static Logical code_isipv4(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(InetAddressValidator.getInstance().isValidInet4Address(String.valueOf(value)));
    }

    public static Logical code_isipv6(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(InetAddressValidator.getInstance().isValidInet6Address(String.valueOf(value)));
    }

    public static Logical code_isurl(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(UrlValidator.getInstance().isValid(String.valueOf(value)));
    }

    public static Logical code_isurn(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(URN_PATTERN.matcher(value).matches());
    }

    public static Logical code_isdn(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(DomainValidator.getInstance().isValid(String.valueOf(value)));
    }

    public static Logical code_istld(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(DomainValidator.getInstance().isValidTld(String.valueOf(value)));
    }

    public static Logical code_iscreditcard(CharSequence value) {
        return code_iscreditcard(value, true);
    }

    public static Logical code_iscreditcard(CharSequence value, boolean normalize) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        if (normalize) {
            return Logical.valueOf(CreditCardValidator.genericCreditCardValidator().isValid(new String(value.codePoints().filter(Character::isDigit).toArray(), 0, value.codePoints().filter(Character::isDigit).toArray().length)));
        } else {
            return Logical.valueOf(CreditCardValidator.genericCreditCardValidator().isValid(String.valueOf(value)));
        }
    }

    public static Logical code_ismod10(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(new Mod10CheckValidator().isValid(value, null));
    }

    public static Logical code_ismod11(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(new Mod11CheckValidator().isValid(value, null));
    }

    public static Logical code_iscnpj(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(new CNPJValidator().isValid(value, null));
    }

    public static Logical code_iscpf(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(new CPFValidator().isValid(value, null));
    }

    public static Logical code_istitulo_eleitoral(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        final Mod11CheckValidator firstValidator = new Mod11CheckValidator();
        firstValidator.initialize(0, 7, 10, false, 9, 'X', '0', Mod11Check.ProcessingDirection.RIGHT_TO_LEFT);

        final Mod11CheckValidator secondValidator = new Mod11CheckValidator();
        secondValidator.initialize(8, 10, 11, false, 9, 'X', '0', Mod11Check.ProcessingDirection.RIGHT_TO_LEFT);

        return Logical.valueOf(firstValidator.isValid(value, null) && secondValidator.isValid(value, null));
    }

    public static Logical code_isnip(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(new NIPValidator().isValid(value, null));
    }

    public static Logical code_ispesel(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(new PESELValidator().isValid(value, null));
    }

    public static Logical code_isregon(CharSequence value) {
        if (value == null || value.length() == 0) {
            return Logical.FALSE;
        }
        return Logical.valueOf(new REGONValidator().isValid(value, null));
    }

    public static Logical code_isjson(CharSequence value) {
        return Logical.TRUE;
    }

    public static Logical code_isxml(CharSequence value) {
        return Logical.TRUE;
    }

    public static Logical code_isyaml(CharSequence value) {
        return Logical.TRUE;
    }

    @SafeHtml(whitelistType = SafeHtml.WhiteListType.RELAXED, additionalTags = {"html", "body", "head"})
    public static class NonStrictSafeHtml {

    }

    @SafeHtml(whitelistType = SafeHtml.WhiteListType.BASIC_WITH_IMAGES, additionalTags = {"html", "body", "head"})
    public static class StrictSafeHtml {

    }
}
