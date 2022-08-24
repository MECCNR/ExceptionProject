import java.util.Arrays;

public class Repository {
    private Product[] goods = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[goods.length + 1];
        for (int i = 0; i < goods.length; i++) {
            tmp[i] = goods[i];
        }
        tmp[tmp.length - 1] = product;
        goods = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Элемент с id: " + id + " не найден");
        }
        Product[] tmp = new Product[goods.length - 1];
        int copyToIndex = 0;
        for (Product product : goods) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        goods = tmp;
    }

    public Product[] findById(int id) {
        Product[] result = new Product[0];
        for (Product product : getGoods()) {
            if (matches(product.getId(), id)) {
                Product[] replacer = new Product[result.length + 1];
                replacer[replacer.length - 1] = product;
                result = replacer;
                System.out.println(Arrays.toString(result));
                return result;
            }
        }
        return null;
    }

    private boolean matches(int id, int id1) {
        if (id == id1) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] getGoods() {
        return goods;
    }


}
