package eu.ase.functional;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        // ================= SETUP =============================
        CloudResource res1 = new CloudResource("res-1", "VM", "eu-west-1", 0.15, 10);
        CloudResource res2 = new CloudResource("res-2", "Storage", "us-east-1", 0.10, 50);
        CloudResource res3 = new CloudResource("res-3", "Database", "eu-central-1", 0.25, 20);
        CloudResource res4 = new CloudResource("res-4", "LoadBalancer", "us-west-2", 0.05, 100);
        CloudResource res5 = new CloudResource("res-5", "Container", "ap-southeast-1", 0.12, 15);
        CloudResource res6 = new CloudResource("res-6", "VM", "eu-west-1", 0.20, 8);
        CloudResource res7 = new CloudResource("res-7", "Storage", "eu-central-1", 0.08, 70);
        CloudResource res8 = new CloudResource("res-8", "Database", "us-east-1", 0.30, 5);
        CloudResource res9 = new CloudResource("res-9", "Container", "eu-west-1", 0.18, 25);
        CloudResource res10 = new CloudResource("res-10", "VM", "ap-southeast-1", 0.22, 12);

        List<CloudResource> allResources = new ArrayList<>();
        allResources.add(res1);
        allResources.add(res2);
        allResources.add(res3);
        allResources.add(res4);
        allResources.add(res5);
        allResources.add(res6);
        allResources.add(res7);
        allResources.add(res8);
        allResources.add(res9);
        allResources.add(res10);

        List<CloudResource> euWest1Resources = new ArrayList<>();
        euWest1Resources.add(res1);
        euWest1Resources.add(res6);
        euWest1Resources.add(res9);


        List<CloudResource> usEast1Resources = new ArrayList<>();
        usEast1Resources.add(res2);
        usEast1Resources.add(res8);

        List<CloudResource> euCentral1Resources = new ArrayList<>();
        euCentral1Resources.add(res3);
        euCentral1Resources.add(res7);

        List<CloudResource> usWest2Resources = new ArrayList<>();
        usWest2Resources.add(res4);

        List<CloudResource> apSoutheast1Resources = new ArrayList<>();
        apSoutheast1Resources.add(res5);
        apSoutheast1Resources.add(res10);

        Map<String, List<CloudResource>> regionMap = new HashMap<>();
        regionMap.put("eu-west-1", euWest1Resources);
        regionMap.put("us-east-1", usEast1Resources);
        regionMap.put("eu-central-1", euCentral1Resources);
        regionMap.put("us-west-2", usWest2Resources);
        regionMap.put("ap-southeast-1", apSoutheast1Resources);

        // ================= SETUP =============================


        // Filter resources with a Predicate (example: uptime > 20)

        Predicate<CloudResource> highUptime = res -> res.getUptimeHours() > 20;

        List<CloudResource> highUptimeResources = allResources.stream()
                .filter(highUptime)
                .toList();

        System.out.println("Resources with uptime > 20:");
        highUptimeResources.forEach(System.out::println);

        System.out.println();
        System.out.println();

        // Map resources to their IDs (Function)

        Function<CloudResource, String> resourceToId = CloudResource::getId;

        List<String> ids = allResources.stream()
                .map(resourceToId)
                .toList();

        System.out.println("Resource IDs:");
        ids.forEach(System.out::println);

        System.out.println();
        System.out.println();

        // Find the resource with the highest uptime cost (max + comparator + lambda)
        allResources.stream()
                .max(Comparator.comparingDouble(CloudResource::uptimeCost))
                .ifPresent(res -> System.out.printf("Highest uptime cost resource: %s | Cost: %.2f\n",
                        res.getId(), res.uptimeCost()));

        System.out.println();
        System.out.println();

        // Count how many VMs exist per region (use the Map and filter with lambda)

        regionMap.forEach((region, resources) -> {
            long vmCount = resources.stream()
                    .filter(res -> res.getType().equals("VM"))
                    .count();

            System.out.printf("Region %s has %d VM(s)\n", region, vmCount);
        });

        System.out.println();
        System.out.println();

        // Get most expensive resources per region (regionMap + sorted + limit)
        regionMap.forEach((region, resources) -> {
            System.out.println("Most expensive resources in region: " + region);

            resources.stream()
                    .sorted((r1, r2) -> Double.compare(r2.uptimeCost(), r1.uptimeCost())) // descending
                    .limit(1)
                    .forEach(res -> System.out.printf("  %s | Cost: %.2f\n", res.getId(), res.uptimeCost()));

            System.out.println();
        });

        System.out.println();
        System.out.println();

        // FlatMap: list all resource IDs in one flat stream

        List<String> allIds = regionMap.values().stream()
                .flatMap(List::stream)
                .map(CloudResource::getId)
                .toList();

        System.out.println("All resource IDs:");
        allIds.forEach(System.out::println);

        System.out.println();
        System.out.println();

    }
}
