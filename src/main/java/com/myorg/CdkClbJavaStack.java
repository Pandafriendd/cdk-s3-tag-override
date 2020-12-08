package com.myorg;

import java.util.*;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;

import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.elasticloadbalancing.LoadBalancer;
import software.amazon.awscdk.services.elasticloadbalancing.LoadBalancerListener;
import software.amazon.awscdk.services.elasticloadbalancing.CfnLoadBalancer;
import software.amazon.awscdk.services.s3.Bucket;
import software.amazon.awscdk.services.s3.CfnBucket;
//import software.amazon.awscdk.services.elasticloadbalancing.PoliciesProperty;  // cannot find symbol!!!

public class CdkClbJavaStack extends Stack {
    public CdkClbJavaStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public CdkClbJavaStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);
        
	  Bucket bucket = Bucket.Builder.create(this, "MyFirstBucket")
      .bucketName("my-first-cdk-java-s3-bucket")
      .versioned(true).build();
      
      // Get the AWS CloudFormation resource
     CfnBucket cfnBucket = (CfnBucket)bucket.getNode().getDefaultChild();
      
      // use index (0 here) to address an element of a list
    //cfnBucket.addOverride("Properties.Tags.0.Value", "NewValue");
    
    cfnBucket.addOverride("Properties.Tags", "[ { \"Value\": \"NewValue\" }, { \"SecondValue\": \"NewValue\" } ]");
      
      //System.out.println("[ { \"Value\": \"NewValue\" }, { \"SecondValue\": \"NewValue\" } ]");
      
      /*
      cfnBucket.setAnalyticsConfigurations(
        Arrays.asList(new HashMap<String, String>() {{
            put("Id", "Config");
        }}));
        */
    }
}
