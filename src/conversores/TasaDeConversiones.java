package conversores;

import com.google.gson.annotations.SerializedName;

public record TasaDeConversiones(@SerializedName("conversion_rates") MonedasParaConvertir conversionRates) {

}
