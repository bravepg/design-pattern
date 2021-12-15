class Singleton {
  instance = null;

  getInstance() {
    if (this.instance == null) {
      this.instance = new Singleton();
      return this.instance;
    }
    return this.instance;
  }
}