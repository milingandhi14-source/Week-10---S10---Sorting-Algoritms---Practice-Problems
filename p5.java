
public class p5 {

    interface Reservable {
        void reserve(String member);
    }

    interface Downloadable {
        void download();
    }

    static abstract class Resource {
        String id;

        Resource(String id) {
            this.id = id;
        }
    }

    static class Book extends Resource implements Reservable {
        Book(String id) {
            super(id);
        }

        public void reserve(String member) {
            System.out.println(id + " reserved for " + member);
        }
    }

    static class EBook extends Resource
            implements Reservable, Downloadable {
        EBook(String id) {
            super(id);
        }

        public void reserve(String member) {
            System.out.println(id + " reserved for " + member);
        }

        public void download() {
            System.out.println(id + " downloaded");
        }
    }

    static class Library {
        Resource[] resources = new Resource[100];
        int size = 0;

        int findIndex(String id) {
            int left = 0, right = size - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int cmp = resources[mid].id.compareTo(id);

                if (cmp == 0) return mid;
                if (cmp < 0) left = mid + 1;
                else right = mid - 1;
            }

            return -1;
        }

        void add(Resource resource) {
            if (findIndex(resource.id) != -1) {
                System.out.println("duplicate rejected");
                return;
            }

            int i = size - 1;
            while (i >= 0 &&
                    resources[i].id.compareTo(resource.id) > 0) {
                resources[i + 1] = resources[i];
                i--;
            }

            resources[i + 1] = resource;
            size++;
            System.out.println(resource.id + " added");
        }

        void reserve(String id, String member) {
            int index = findIndex(id);

            if (index == -1) {
                System.out.println(id + " not found");
                return;
            }

            Resource resource = resources[index];

            if (resource instanceof Reservable) {
                ((Reservable) resource).reserve(member);
            } else {
                System.out.println(id + " rejected: reserve unsupported");
            }
        }

        void download(String id) {
            int index = findIndex(id);

            if (index == -1) {
                System.out.println(id + " not found");
                return;
            }

            Resource resource = resources[index];

            if (resource instanceof Downloadable) {
                ((Downloadable) resource).download();
            } else {
                System.out.println(id + " rejected: download unsupported");
            }
        }

        void find(String id) {
            int index = findIndex(id);

            if (index == -1) {
                System.out.println(id + " not found");
            } else {
                System.out.println(id + " found at index " + index);
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        library.add(new Book("B1"));
        library.add(new Book("B1"));
        library.add(new EBook("E1"));

        library.reserve("B1", "M1");
        library.download("B1");
        library.download("E1");
        library.find("E1");
    }
}
