package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {
	
	public static RequestSpecification reqSpec()
	{
		return  new RequestSpecBuilder()
		
		.setBaseUri("https://api.spotify.com")
		.setBasePath("/v1")
		.setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer BQD2seSdtY0Jn8QAD7GsAnHiwJDMIhpngg6Mva3OyxRdfRl7ZHSSb6fLf47dTp7qQrrypsac3NwvGFg_7RhArQmYni6avJ5keB_FMjn9WdHBATLzpEozrvpA3KDfZeMqhvu1gXg2wRzSEbY5y594SiwQiZz86eqlInLfAyXjj-8vsqpmMOEczmUcsZTXClewpd9yzz5B79uqd6RpocRlm-7YIlAGNFqKWg29QVdJRpdhOcPHK2nAfIPFPYdMKza5ylzFtOSXhpGjW__J")
		.log(LogDetail.ALL)
		.build();
	}
	
	
	public static ResponseSpecification resSpec()
	{ 
		return new ResponseSpecBuilder()
	 	 
		 .expectContentType(ContentType.JSON)
		 .log(LogDetail.ALL)
		 .build();
		
	}

}
